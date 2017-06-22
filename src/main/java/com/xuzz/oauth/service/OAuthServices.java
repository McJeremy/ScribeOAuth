package com.xuzz.oauth.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by win10 on 2017/6/21.
 */
@Service
public class OAuthServices {
    @Autowired
    List<CustomOAuthService> oAuthServices;

    public CustomOAuthService getOAuthService(String type){
       /* Optional<CustomOAuthService> oAuthService = oAuthServiceDeractors.stream().filter(o -> o.getoAuthType().equals(type))
                .findFirst();
        if(oAuthService.isPresent()){
            return oAuthService.get();
        }*/
       for(CustomOAuthService service : oAuthServices)
       {
           if(service.getoAuthType()==type)
           {
               return service;
           }
       }
        return null;
    }

    public List<CustomOAuthService> getAllOAuthServices(){
        return oAuthServices;
    }
}
