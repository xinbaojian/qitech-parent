package com.qitech.qitechdemo.service.impl;

import com.qitech.qitechdemo.annotation.CacheExpire;
import com.qitech.qitechdemo.dao.SysDictMapper;
import com.qitech.qitechdemo.entity.SysDict;
import com.qitech.qitechdemo.entity.SysDictExample;
import com.qitech.qitechdemo.service.IDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author xinbj
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DictServiceImpl implements IDictService {

    @Autowired
    private SysDictMapper sysDictMapper;

    @CacheExpire(500)
    @Cacheable(value = "dict:list", key = "#root.methodName")
    @Override
    public List<SysDict> list() {
        return sysDictMapper.selectByExample(new SysDictExample());
    }
}
