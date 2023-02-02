package com.br.actionsitesale.controller.dto.BrokerUser;

import com.br.actionsitesale.model.Users;
import com.br.actionsitesale.model.enums.StatusLogin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataResponse {

    @Id
    private String id;
    private String login;
    private String password;
    private String numberCorp;
    private String emailCorp;
    private StatusLogin statusCorp;

    public static DataResponse converter(Users c){
        return DataResponse.builder()
                .id(c.getId())
                .login(c.getLogin())
                .password(c.getPassword())
                .numberCorp(c.getNumberCorp())
                .emailCorp(c.getEmailCorp())
                .statusCorp(c.getStatusCorp())
                .build();
    }
}