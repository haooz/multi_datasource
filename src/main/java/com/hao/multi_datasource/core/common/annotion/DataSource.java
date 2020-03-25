package com.hao.multi_datasource.core.common.annotion;

import com.hao.multi_datasource.core.common.constant.DataSourceType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义多数据源切换
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    /**
     * 切换数据源名称
     * @return
     */
    public DataSourceType value() default DataSourceType.MASTER;
}
