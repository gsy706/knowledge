package com.gsy.mysql;

import com.gsy.mysql.insert.InsertService;
import com.gsy.mysql.query.QueryService;
import com.gsy.mysql.query.QueryServiceV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootApplication
public class MysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlApplication.class, args);
    }

//    public MysqlApplication(JdbcTemplate jdbcTemplate){
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from subscribe");
//        log.info("result: {}",maps);
//    }

//    public MysqlApplication(InsertService insertService){
//        insertService.basicInsert();
//        insertService.batchInsert();
//    }

    public MysqlApplication(QueryServiceV2 queryService){
        queryService.queryForRowSet();
        queryService.query();
    }

}
