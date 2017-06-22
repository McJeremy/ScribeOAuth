package com.xuzz.oauth.api;

import com.xuzz.oauth.service.SinaweiboOAuthService;
import com.xuzz.oauth.service.WeixinOAuthService;
import org.scribe.builder.api.DefaultApi20;
import org.scribe.builder.api.SinaWeiboApi20;
import org.scribe.model.OAuthConfig;
import org.scribe.oauth.OAuthService;
import org.scribe.utils.OAuthEncoder;

public class SinaWeiboApi extends SinaWeiboApi20 {

    @Override
    public OAuthService createService(OAuthConfig config){
        return new SinaweiboOAuthService(this, config);
    }
}
