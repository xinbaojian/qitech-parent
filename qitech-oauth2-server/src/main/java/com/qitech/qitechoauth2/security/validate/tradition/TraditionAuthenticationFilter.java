package com.qitech.qitechoauth2.security.validate.tradition;

import com.qitech.qitechoauth2.constant.SecurityConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author xinbj
 * @date 2019/12/20 16:41
 */
public class TraditionAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    /**
     * 是否仅 POST 方式
     */
    private boolean postOnly = true;

    private String SPRING_SECURITY_FORM_USERNAME_KEY = "username";

    private String SPRING_SECURITY_FORM_PASSWORD_KEY = "password";

    protected TraditionAuthenticationFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String postType = "POST";
        if (postOnly && !postType.equals(request.getMethod())) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }

        //TODO 有验证码可在此处理
//        String verifyCode = request.getParameter(SecurityConstant.VALIDATE_CODE_PARAMETER);
//
//        if (!validateVerify(verifyCode)) {
//            throw new DefaultAuthException("验证码输入错误");
//        }

        String username = request.getParameter(SPRING_SECURITY_FORM_USERNAME_KEY);
        String password = request.getParameter(SPRING_SECURITY_FORM_PASSWORD_KEY);

        TraditionAuthenticationToken authRequest = new TraditionAuthenticationToken(username, password);

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }

    /**
     * 验证验证码
     *
     * @param inputVerify
     * @return
     */
    private boolean validateVerify(String inputVerify) {
        //获取当前线程绑定的request对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        HttpSession session = request.getSession();

        Object validateCode = session.getAttribute("validateCode");
        if (validateCode == null) {
            return false;
        }

        // 不分区大小写
        return StringUtils.equalsIgnoreCase((String) validateCode, inputVerify);
    }

    private void setDetails(HttpServletRequest request, TraditionAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }

}
