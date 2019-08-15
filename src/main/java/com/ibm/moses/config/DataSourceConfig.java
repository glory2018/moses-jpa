package com.ibm.moses.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Moses
 */
@Configuration
public class DataSourceConfig {
    public final static String WRITE_DATASOURCE_KEY1 = "writeDatasource1";
    public final static String READ_DATASOURCE_KEY1 = "readDatasource1";
    public final static String WRITE_DATASOURCE_KEY2 = "writeDatasource2";
    public final static String READ_DATASOURCE_KEY2 = "readDatasource2";

    @Bean(name = "writeJdbcTemplate1")
    public JdbcTemplate writeJdbcTemplate1(@Qualifier("writeDataSource1") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "readJdbcTemplate1")
    public JdbcTemplate readJdbcTemplate1(@Qualifier("readDataSource1") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "writeJdbcTemplate2")
    public JdbcTemplate writeJdbcTemplate2(@Qualifier("writeDataSource2") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "readJdbcTemplate2")
    public JdbcTemplate readJdbcTemplate2(@Qualifier("readDataSource2") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @ConfigurationProperties(prefix = "spring.datasource.read1")
    @Bean(name = READ_DATASOURCE_KEY1)
    @Qualifier("readDataSource1")
    public DataSource readDruidDataSource1() {
        return new DruidDataSource();
    }

    @ConfigurationProperties(prefix = "spring.datasource.write1")
    @Qualifier("writeDataSource1")
    @Bean(name = WRITE_DATASOURCE_KEY1)
    @Primary
    public DataSource writeDruidDataSource1() {
        return new DruidDataSource();
    }

    @ConfigurationProperties(prefix = "spring.datasource.read2")
    @Bean(name = READ_DATASOURCE_KEY2)
    @Qualifier("readDataSource2")
    public DataSource readDruidDataSource2() {
        return new DruidDataSource();
    }

    @ConfigurationProperties(prefix = "spring.datasource.write2")
    @Qualifier("writeDataSource2")
    @Bean(name = WRITE_DATASOURCE_KEY2)
    public DataSource writeDruidDataSource2() {
        return new DruidDataSource();
    }

    /**
     * 注入AbstractRoutingDataSource
     *
     * @param readDruidDataSource1
     * @param writeDruidDataSource1
     * @param readDruidDataSource2
     * @param writeDruidDataSource2
     * @return
     * @throws Exception
     */
    @Bean
    public AbstractRoutingDataSource routingDataSource(
            @Qualifier(READ_DATASOURCE_KEY1) DataSource readDruidDataSource1,
            @Qualifier(WRITE_DATASOURCE_KEY1) DataSource writeDruidDataSource1,
            @Qualifier(READ_DATASOURCE_KEY2) DataSource readDruidDataSource2,
            @Qualifier(WRITE_DATASOURCE_KEY2) DataSource writeDruidDataSource2) throws Exception {
        DynamicDataSource dataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>(4);
        targetDataSources.put(WRITE_DATASOURCE_KEY1, writeDruidDataSource1);
        targetDataSources.put(READ_DATASOURCE_KEY1, readDruidDataSource1);
        targetDataSources.put(WRITE_DATASOURCE_KEY2, writeDruidDataSource2);
        targetDataSources.put(READ_DATASOURCE_KEY2, readDruidDataSource2);
        dataSource.setTargetDataSources(targetDataSources);
        dataSource.setDefaultTargetDataSource(writeDruidDataSource1);
        return dataSource;
    }
}