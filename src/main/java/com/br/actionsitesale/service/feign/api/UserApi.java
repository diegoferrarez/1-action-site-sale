package com.br.actionsitesale.service.feign.api;

import com.br.actionsitesale.controller.dto.response.credential.TokenResponse;
import com.br.actionsitesale.service.feign.UserFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RefreshScope
public class UserApi {
    private final UserFeign userFeign;

    public UserApi(UserFeign userFeign) {
        this.userFeign = userFeign;
    }

    public TokenResponse getByName(String unit, String serialNumberUnit){
        return userFeign.getByName(unit, serialNumberUnit);
    }
}
