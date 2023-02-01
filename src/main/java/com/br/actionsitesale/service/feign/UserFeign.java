package com.br.actionsitesale.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Component
@FeignClient(name = "user", url = "${feign.url.user}")
public interface UserFeign {
//
//    @GetMapping(value = "/credentialToken") TokenResponse getCredentialByHeader(
//            @RequestHeader(ProviderExtranetConstants.BRANCH_ID_HEADER) String branchId,
//            @RequestHeader(name = ProviderExtranetConstants.AGENT_SIGN_HEADER) String agentSign,
//            @RequestHeader(name = ProviderExtranetConstants.PROVIDER_HEADER) String provider);
}