package com.br.actionsitesale.service.feign;

import com.br.actionsitesale.controller.dto.BrokerUser.DataResponse;
import com.br.actionsitesale.utils.UserConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Component
@FeignClient(name = "user", url = "${feign.url.user}")
public interface UserFeign {

    @GetMapping(value = "/findby/name") DataResponse getByName(
            @RequestHeader(name = UserConstants.USER_SIGN_HEADER)String userLogin,
            @RequestHeader(name = UserConstants.USER_PASS_HEADER)String password);
}