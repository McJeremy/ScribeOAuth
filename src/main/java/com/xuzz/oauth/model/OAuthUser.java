package com.xuzz.oauth.model;

/**
 * Created by win10 on 2017/6/21.
 */
public class OAuthUser {
    private Integer id;
    private String oAuthType;
    private String oAuthId;
    public String getoAuthType() {
        return oAuthType;
    }
    public void setoAuthType(String oAuthType) {
        this.oAuthType = oAuthType;
    }
    public String getoAuthId() {
        return oAuthId;
    }
    public void setoAuthId(String oAuthId) {
        this.oAuthId = oAuthId;
    }
}
