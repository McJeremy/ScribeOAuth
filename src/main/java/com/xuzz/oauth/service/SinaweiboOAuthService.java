package com.xuzz.oauth.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;
import com.xuzz.oauth.consts.OAuthTypes;
import com.xuzz.oauth.model.OAuthUser;
import org.scribe.builder.api.DefaultApi20;
import org.scribe.model.*;
import org.scribe.oauth.OAuth20ServiceImpl;

public class SinaweiboOAuthService extends OAuth20ServiceImpl implements CustomOAuthService {

    private static final String PROTECTED_RESOURCE_URL = "https://api.weibo.com/oauth2/get_token_info";

    private final DefaultApi20 api;
    private final OAuthConfig config;

    public SinaweiboOAuthService(DefaultApi20 api, OAuthConfig config) {
        super(api, config);
        this.api = api;
        this.config = config;
    }

    public OAuthUser getOAuthUser(Token accessToken) {
        OAuthRequest request = new OAuthRequest(Verb.POST, PROTECTED_RESOURCE_URL);
        this.signRequest(accessToken, request);
        Response response = request.send();
        OAuthUser oAuthUser = new OAuthUser();
        oAuthUser.setoAuthType(getoAuthType());
        oAuthUser.setoAuthId(JSONPath.eval(JSON.parse(response.getBody()), "$.uid").toString());
        return oAuthUser;
    }

    public String getoAuthType() {
        return OAuthTypes.SINA_WEIBO;
    }

    public String getAuthorizationUrl() {
        return api.getAuthorizationUrl(config);
    }
}