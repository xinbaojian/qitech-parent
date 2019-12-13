package com.qitech.qitechdemo.dao;

import com.qitech.qitechdemo.entity.SysDict;
import com.qitech.qitechdemo.entity.SysDictExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDictMapper {
    long countByExample(SysDictExample example);

    int deleteByExample(SysDictExample example);

    int insert(SysDict record);

    int insertSelective(SysDict record);

    List<SysDict> selectByExample(SysDictExample example);

    int updateByExampleSelective(@Param("record") SysDict record, @Param("example") SysDictExample example);

    int updateByExample(@Param("record") SysDict record, @Param("example") SysDictExample example);
}