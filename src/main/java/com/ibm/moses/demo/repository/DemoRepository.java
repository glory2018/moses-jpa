package com.ibm.moses.demo.repository;

import com.ibm.moses.config.DataSourceConfig;
import com.ibm.moses.config.TargetDateSource;
import com.ibm.moses.demo.entity.Demo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Moses
 */
public interface DemoRepository extends JpaRepository<Demo, String> {
    /**
     * find by uuid
     *
     * @param id Primary key
     * @return
     */
    @TargetDateSource(dataSource = DataSourceConfig.WRITE_DATASOURCE_KEY1)
    Demo findByUuid(String id);

    /**
     * find by name
     *
     * @param name
     * @return
     */
    @TargetDateSource(dataSource = DataSourceConfig.WRITE_DATASOURCE_KEY1)
    Demo findByName(String name);

    /**
     * find all
     *
     * @return
     */
    @TargetDateSource(dataSource = DataSourceConfig.WRITE_DATASOURCE_KEY1)
    List<Demo> findAllByOrderByCreateTime();

    /**
     * find all by condition
     *
     * @param specification
     * @param pageable
     * @return
     */
    @TargetDateSource(dataSource = DataSourceConfig.WRITE_DATASOURCE_KEY1)
    Page<Demo> findAll(Specification specification, Pageable pageable);
}
