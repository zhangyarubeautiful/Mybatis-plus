package com.xihua.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;

/**
 * 自定义公共字段填充处理器
 */
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入操作自动填充
     * @param metaObject 元数据对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 获取到需要被填充的字段值
        Object field = getFieldValByName("email", metaObject);
        if(field == null){
            log.info("****插入操作满足填充条件***");
            System.out.println("****插入操作满足填充条件***");
            setFieldValByName("email","insertFill@fill.com",metaObject);
        }
    }

    /**
     * 更新操作自动填充
     * @param metaObject 元数据对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        // 获取到需要被填充的字段值
        Object field = getFieldValByName("email", metaObject);
        if(field == null){
            log.info("****修改操作满足填充条件***");
            System.out.println("****修改操作满足填充条件***");
            setFieldValByName("email","updateFill@fill.com",metaObject);
        }
    }
}
