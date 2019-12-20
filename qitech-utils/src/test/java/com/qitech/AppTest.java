package com.qitech;

import cn.hutool.core.lang.UUID;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        System.out.println(UUID.randomUUID().toString(true));
        System.out.println(UUID.randomUUID().toString(true));
        assertTrue(true);
    }
}
