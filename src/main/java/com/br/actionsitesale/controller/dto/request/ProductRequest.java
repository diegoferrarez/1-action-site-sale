package com.br.actionsitesale.controller.dto.request;

import com.br.actionsitesale.model.UserAuth;
import com.br.actionsitesale.model.enums.Sizes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @Id
    private String id;
    private String idInternal;
    private String nameProduct;
    private Sizes sizeProduct;
    private BigDecimal valueProduct;
    private UserAuth user;
}