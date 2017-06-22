package com.xuzz.oauth.build;

import com.xuzz.oauth.api.SinaWeiboApi;
import com.xuzz.oauth.api.WeixinApi;
import com.xuzz.oauth.service.CustomOAuthService;
import com.xuzz.oauth.service.SinaweiboOAuthService;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.Api;
import org.scribe.builder.api.SinaWeiboApi20;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by win10 on 2017/6/21.
 */
@Configuration
@PropertySource("classpath:oauth.properties")
public class SinaWeiboBuild {

    @Value("${oAuth.sina.appKey}") String sinaAppKey;
    @Value("${oAuth.sina.appSecret}") String sinaAppSecret;
    @Value("${oAuth.sina.callback}") String sinaCallback_Url;

    @Bean
    public CustomOAuthService getWeixinOAuthService(){
        return (CustomOAuthService) new ServiceBuilder()
                .provider(SinaWeiboApi.class)
                .apiKey(sinaAppKey)
                .apiSecret(sinaAppSecret)
                .callback(sinaCallback_Url)
                .build();
    }
}
