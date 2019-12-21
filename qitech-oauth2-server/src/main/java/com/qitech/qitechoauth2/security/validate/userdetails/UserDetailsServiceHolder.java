package com.qitech.qitechoauth2.security.validate.userdetails;

import com.qitech.qitechoauth2.exception.UserDetailsServiceException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

/**
 * @author xinbj
 * @date 2019/12/21 17:28
 */
@Component
@RequiredArgsConstructor
public class UserDetailsServiceHolder {

    private final @NonNull Map<String, UserDetailsService> userDetailsServiceMap;

    public UserDetailsService findUserDetailsService(String type) {
        String name = type.toLowerCase() + UserDetailsService.class.getSimpleName();
        UserDetailsService userDetailsService = userDetailsServiceMap.get(name);
        if (Objects.isNull(userDetailsService)) {
            throw new UserDetailsServiceException("验证码处理器" + name + "不存在");
        }
        return userDetailsService;
    }
}
