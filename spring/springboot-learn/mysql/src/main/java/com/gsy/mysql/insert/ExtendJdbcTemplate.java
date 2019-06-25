/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.mysql.insert;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-25
 */
@Component
public class ExtendJdbcTemplate extends JdbcTemplate {

    public ExtendJdbcTemplate(DataSource dataSource) {
        super(dataSource);
    }

    public int[] batchUpdate(final String sql, final BatchPreparedStatementSetter pss,
                             final KeyHolder generatedKeyHolder) throws DataAccessException {
        return execute(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                return conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            }
        }, ps -> {
            try {
                int batchSize = pss.getBatchSize();
                int totalRowsAffected = 0;
                int[] rowsAffected = new int[batchSize];
                List generatedKeys = generatedKeyHolder.getKeyList();
                generatedKeys.clear();
                ResultSet keys = null;
                for (int i = 0; i < batchSize; i++) {
                    pss.setValues(ps, i);
                    rowsAffected[i] = ps.executeUpdate();
                    totalRowsAffected += rowsAffected[i];
                    try {
                        keys = ps.getGeneratedKeys();
                        if (keys != null) {
                            RowMapper rowMapper = new ColumnMapRowMapper();
                            RowMapperResultSetExtractor rse = new RowMapperResultSetExtractor(rowMapper, 1);
                            generatedKeys.addAll(rse.extractData(keys));
                        }
                    } finally {
                        JdbcUtils.closeResultSet(keys);
                    }
                }
                if (logger.isDebugEnabled()) {
                    logger.debug("SQL batch update affected " + totalRowsAffected + " rows and returned " +
                            generatedKeys.size() + " keys");
                }
                return rowsAffected;
            } finally {
                if (pss instanceof ParameterDisposer) {
                    ((ParameterDisposer) pss).cleanupParameters();
                }
            }
        });
    }

}
