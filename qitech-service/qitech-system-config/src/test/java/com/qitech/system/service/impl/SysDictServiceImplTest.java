package com.qitech.system.service.impl;

import com.qitech.system.service.ISysDictService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SysDictServiceImplTest {

    @Autowired
    private ISysDictService sysDictService;

    @Test
    public void addDict() {
        System.out.println(sysDictService.list().size());
    }
}