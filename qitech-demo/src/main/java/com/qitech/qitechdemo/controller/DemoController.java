package com.qitech.qitechdemo.controller;

import com.qitech.qitechdemo.constant.UrlConstant;
import com.qitech.qitechdemo.entity.SysDict;
import com.qitech.qitechdemo.service.IDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xinbj
 * @date 2019/12/13 15:19
 */
@RestController
@RequestMapping(UrlConstant.ROOT)
public class DemoController {

    private IDictService dictService;

    @Autowired
    public DemoController(IDictService dictService) {
        this.dictService = dictService;
    }

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        List<SysDict> list = dictService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
