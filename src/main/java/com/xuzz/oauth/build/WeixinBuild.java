package com.xuzz.oauth.build;

import com.xuzz.oauth.api.WeixinApi;
import com.xuzz.oauth.consts.OAuthTypes;
import com.xuzz.oauth.service.CustomOAuthService;
import org.scribe.builder.ServiceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by win10 on 2017/6/21.
 */
@Configuration
@PropertySource("classpath:oauth.properties")
public class WeixinBuild {

    @Value("${oAuth.weixin.appId}") String weixinAppId;
    @Value("${oAuth.weixin.appSecret}") String weixinAppSecret;
    @Value("${oAuth.weixin.callback}") String weixinCallback_Url;
    @Bean
    public CustomOAuthService getWeixinOAuthService(){
        return (CustomOAuthService) new ServiceBuilder()
                .provider(WeixinApi.class)
                .apiKey(weixinAppId)
                .apiSecret(weixinAppSecret)
                .scope("snsapi_login")
                .callback(weixinCallback_Url)
                .build();
    }
}
