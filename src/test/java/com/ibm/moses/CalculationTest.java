/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.moses.CalculationTest
 * @version V1.0
 */
package com.ibm.moses;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Moses
 * @date 2019/8/15
 */
public class CalculationTest {
    @Test
    public void testAdd() {
        assertEquals(5, Calculation.add(3, 2));
    }

    @Test
    public void testsubstract() {
        assertEquals(2, Calculation.sub(5, 3));
    }
}
