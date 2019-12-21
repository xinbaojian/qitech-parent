package com.qitech.qitechoauth2.service.impl;

import com.qitech.qitechoauth2.service.IValidateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户名密码登录
 *
 * @author xinbj
 * @date 2019/12/21 11:46
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UsernamePasswordValidateServiceImpl implements IValidateService {

}
