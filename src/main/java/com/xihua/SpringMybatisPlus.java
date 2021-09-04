package com.xihua;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Spring mybatis plus.
 *
 * @author liyu
 */
@SpringBootApplication
@MapperScan(value = "com.xihua.dao")
public class SpringMybatisPlus {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringMybatisPlus.class,args);
    }

}
