package com.qitech.qitechoauth2.config;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

/**
 * @author xinbj
 * @date 2019/12/18 16:50
 */
@Configuration
@RequiredArgsConstructor
@EnableAuthorizationServer
public class Oauth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final @NonNull AuthenticationManager authenticationManager;

    private final @NonNull OauthClientDetails clientDetails;

    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * 配置授权服务器各个端点的非安全功能，如令牌存储，令牌自定义，用户批准和授权类型。
     * 如果需要密码授权模式，需要提供 AuthenticationManager 的 bean。
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(this.authenticationManager);
    }

    /**
     * 配置客户端的 service，也就是应用怎么获取到客户端的信息，一般来说是从内存或者数据库中获取，
     * 已经提供了他们的默认实现，你也可以自定义。
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        InMemoryClientDetailsServiceBuilder builder = clients.inMemory();
//        builder.
//                //构建一个id为 oauth2 的客户端
//                        withClient("oauth2")
//                //设置密钥，加密后的
//                .secret(passwordEncoder.encode("oauth2"))
//                //设置允许方位的资源id
//                .resourceIds("oauth2")
//                //设置授权类型
//                .authorizedGrantTypes("password", "authorization_code", "refresh_token")
//                //可以授权的角色
//                .authorities("ROLE_ADMIN", "ROLE_USER")
//                //授权的范围
//                .scopes("all")
//                //token有效期
//                .accessTokenValiditySeconds(Math.toIntExact(Duration.ofHours(1).getSeconds()))
//                //刷新token有效期
//                .refreshTokenValiditySeconds(Math.toIntExact(Duration.ofHours(1).getSeconds()))
//                //跳转url
//                .redirectUris("http://example.com");
        configClient(clients);
//        super.configure(clients);
    }

    /**
     * 从配置文件读取oauth2 客户端配置信息
     *
     * @param clients
     * @throws Exception
     */
    private void configClient(ClientDetailsServiceConfigurer clients) throws Exception {
        InMemoryClientDetailsServiceBuilder builder = clients.inMemory();
        for (BaseClientDetails client : clientDetails.getClient()) {
            ClientDetailsServiceBuilder<InMemoryClientDetailsServiceBuilder>.ClientBuilder clientBuilder =
                    builder.withClient(client.getClientId());
            clientBuilder
                    .secret(passwordEncoder.encode(client.getClientSecret()))
                    .resourceIds(client.getResourceIds().toArray(new String[0]))
                    .authorizedGrantTypes(client.getAuthorizedGrantTypes().toArray(new String[0]))
                    .authorities(
                            AuthorityUtils.authorityListToSet(client.getAuthorities())
                                    .toArray(new String[0]))
                    .scopes(client.getScope().toArray(new String[0]));
            if (client.getAutoApproveScopes() != null) {
                clientBuilder.autoApprove(
                        client.getAutoApproveScopes().toArray(new String[0]));
            }
            if (client.getAccessTokenValiditySeconds() != null) {
                clientBuilder.accessTokenValiditySeconds(
                        client.getAccessTokenValiditySeconds());
            }
            if (client.getRefreshTokenValiditySeconds() != null) {
                clientBuilder.refreshTokenValiditySeconds(
                        client.getRefreshTokenValiditySeconds());
            }
            if (client.getRegisteredRedirectUri() != null) {
                clientBuilder.redirectUris(
                        client.getRegisteredRedirectUri().toArray(new String[0]));
            }
        }
    }

}
