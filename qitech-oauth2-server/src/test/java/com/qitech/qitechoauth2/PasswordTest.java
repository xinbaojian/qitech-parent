package com.qitech.qitechoauth2;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author xinbj
 * @date 2019/12/18 17:09
 */
public class PasswordTest {

    @Test
    public void password() {
        // 每次打印的结果都不一样，不影响
        System.out.println(new BCryptPasswordEncoder().encode("websecret"));
        System.out.println(new BCryptPasswordEncoder().encode("clientsecret"));
    }
}
