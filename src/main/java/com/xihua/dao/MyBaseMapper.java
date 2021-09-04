package com.xihua.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface My base mapper.
 *
 * @param <T> the type parameter
 */
@Repository
public interface MyBaseMapper<T> extends BaseMapper<T> {
    /**
     * 自定义通用方法
     *
     * @return the integer
     */
    Integer deleteAll();

    /**
     * My insert all int.
     *
     * @param entity the entity
     * @return the int
     */
    int myInsertAll(T entity);

    /**
     * 如果要自动填充，@{@code Param}(xx) xx参数名必须是 list/collection/array 3个的其中之一
     *
     * @param batchList the batch list
     * @return int int
     */
    int mysqlInsertAllBatch(@Param("list") List<T> batchList);
}
