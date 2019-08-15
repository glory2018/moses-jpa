package com.ibm.moses.config;

import java.lang.annotation.*;

/**
 * @author Moses
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDateSource {
    String dataSource() default DataSourceConfig.WRITE_DATASOURCE_KEY1;// 数据源
}
