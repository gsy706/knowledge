/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.mysql.insert;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-24
 */
public class InsertService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private boolean insertBySql() {
        String sql = "insert into money ('name','money') values ('斯塔克', '999999999')";
        int update = jdbcTemplate.update(sql);
        return update > 0;
    }

    private boolean insertByParams(){
        // 使用占位符
        String sql = "insert into money ('name','money') values (?,?)";
        int update = jdbcTemplate.update(sql, "gsy", 88888888);
        return update > 0;
    }

    /**
     * 使用statement插入
     */
    private boolean insertByStatement(){
        // 安全
        // 设置参数时起始值为1
        String sql = "insert into money ('name','money','is_deleted') values (?,?,?)";
        return jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1,"浩克");
                preparedStatement.setInt(2,100);
                preparedStatement.setByte(3, (byte) 0);
            }
        }) > 0;
    }

    private boolean insertByStatement2(){
        String sql = "insert into money ('name','money') values (?,?)";
        return jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,"小蜘蛛");
                preparedStatement.setInt(2,200);
                return preparedStatement;
            }
        }) > 0;
    }

    /**
     * 插入并返回主键Id
     */
    private int insertAndReturnId(){
        String sql = "insert into money ('name','money') values (?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                // 指定主键，不指定会报错
                PreparedStatement preparedStatement = connection.prepareStatement(sql,new String[]{"id"});
                preparedStatement.setString(1,"队长");
                preparedStatement.setInt(2,300);
                return preparedStatement;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    /**
     * 批量插入
     */
    private void batchInsertBySql() {
        String sql = "INSERT INTO `money` (`name`, `money`) VALUES ('Batch gsy', 999), ('Batch gsy 2', 666);";
        int[] ans = jdbcTemplate.batchUpdate(sql);
        System.out.println("batch insert by sql: " + JSON.toJSONString(ans));
    }

    /**
     * 批量插入
     */
    private void batchInsertByParams() {
        String sql = "INSERT INTO `money` (`name`, `money`) VALUES (?, ?);";

        Object[] param1 = new Object[]{"Batch gsy 3", 888};
        Object[] param2 = new Object[]{"Batch gsy 4", 168};
        int[] ans = jdbcTemplate.batchUpdate(sql, Arrays.asList(param1, param2));
        System.out.println("batch insert by params: " + JSON.toJSONString(ans));
    }

}
