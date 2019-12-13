package com.qitech.qitechdemo.service.impl;

import com.qitech.qitechdemo.entity.SysDict;
import com.qitech.qitechdemo.service.IDictService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DictServiceImplTest {

    @Autowired
    private IDictService dictService;

    @Test
    void list() {
        System.out.println("----");
        List<SysDict> list = dictService.list();
        list.forEach(System.out::println);
    }
}