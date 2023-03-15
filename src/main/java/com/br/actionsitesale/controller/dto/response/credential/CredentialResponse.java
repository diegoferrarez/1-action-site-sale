package com.br.actionsitesale.controller.dto.response.credential;

import com.br.actionsitesale.model.Token;
import com.br.actionsitesale.model.enums.StatusLogin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CredentialResponse {

    private String id;
    private String unit;
    private String serialNumberUnit;
    private Token credential;
    private StatusLogin statusCorp;
}
