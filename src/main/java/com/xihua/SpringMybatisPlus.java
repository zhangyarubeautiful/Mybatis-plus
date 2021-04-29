package com.xihua;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liyu
 */
@SpringBootApplication
@MapperScan(value = "com.xihua.dao")
public class SpringMybatisPlus {
    public static void main(String[] args) {
        SpringApplication.run(SpringMybatisPlus.class,args);
    }

}
