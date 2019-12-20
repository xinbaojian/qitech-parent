package com.qitech.qitechoauth2.service.impl;

import com.qitech.qitechoauth2.dao.SysUserMapper;
import com.qitech.qitechoauth2.entity.SysUser;
import com.qitech.qitechoauth2.entity.SysUserExample;
import com.qitech.qitechoauth2.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

/**
 * @author xinbj
 * @date 2019/12/20 15:11
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserServiceImpl implements ISysUserService {

    private SysUserMapper sysUserMapper;

    @Autowired
    public SysUserServiceImpl(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    @Override
    public SysUser selectByPrimaryKey(String id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public Optional<SysUser> selectByUsername(String username) {
        SysUserExample example = new SysUserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<SysUser> list = sysUserMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(list)){
            return Optional.of(list.get(0));
        }
        return Optional.empty();
    }
}
