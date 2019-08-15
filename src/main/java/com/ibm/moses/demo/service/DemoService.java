package com.ibm.moses.demo.service;

import com.ibm.moses.demo.entity.Demo;
import com.ibm.moses.demo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Moses
 */
@Service
public class DemoService {
    @Autowired
    private DemoRepository demoRepository;

    public List<Demo> findAll() {
        return demoRepository.findAllByOrderByCreateTime();
    }
}
