package com.br.actionsitesale.service.feign;

import com.br.actionsitesale.controller.dto.response.credential.TokenResponse;
import com.br.actionsitesale.utils.UserConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Component
@FeignClient(name = "user", url = "${feign.url.user}")
public interface UserFeign {

    @GetMapping(value = "/findby/name") TokenResponse getByName(
            @RequestHeader(name = UserConstants.USER_UNIT_HEADER)String unit,
            @RequestHeader(name = UserConstants.SERIAL_UNIT_NUMBER)String serialNumberUnit);
}