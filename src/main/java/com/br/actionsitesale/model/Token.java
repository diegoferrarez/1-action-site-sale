package com.br.actionsitesale.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Token {
    private String userName;
    private String password;
    private String numberCorp;
    private String emailCorp;

    public Token() {
    }

    public Token(String userName, String password, String numberCorp, String emailCorp) {
        this.userName = userName;
        this.password = password;
        this.numberCorp = numberCorp;
        this.emailCorp = emailCorp;
    }
}
