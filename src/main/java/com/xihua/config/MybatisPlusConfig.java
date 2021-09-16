package com.xihua.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.xihua.handler.MyMetaObjectHandler;
import com.xihua.injector.MyLogicSqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 分页插件,使用selectPage方法时会被拦截器拦截
 */
@Configuration
@MapperScan("com.xihua.dao")
public class MybatisPlusConfig {

    /**
     * Mybatis plus interceptor mybatis plus interceptor.
     *
     * @return the mybatis plus interceptor
     */
    // 最新版
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    /**
     * 自定义 SqlInjector
     * 里面包含自定义的全局方法
     *
     * @return the my logic sql injector
     */
    @Bean
    public MyLogicSqlInjector myLogicSqlInjector() {
        return new MyLogicSqlInjector();
    }

    /**
     * 自定义公共字段填充处理器
     *
     * @return the my meta object handler
     */
    @Bean
    public MyMetaObjectHandler myMetaObjectHandler(){
        return new MyMetaObjectHandler();
    }
}
