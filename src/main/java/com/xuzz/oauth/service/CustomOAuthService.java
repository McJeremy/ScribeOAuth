package com.xuzz.oauth.service;

import com.xuzz.oauth.model.OAuthUser;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;


public interface CustomOAuthService extends OAuthService{
     String getoAuthType();
    String getAuthorizationUrl();
    OAuthUser getOAuthUser(Token accessToken);
}