/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.mysql.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-07-04
 */
@Component
public class DeleteService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void delete() {
        int ans = jdbcTemplate.update("delete from money where id = 13");
        System.out.println("delete: " + ans);
    }

}
