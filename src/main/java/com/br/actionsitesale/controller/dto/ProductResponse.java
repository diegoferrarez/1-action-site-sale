package com.br.actionsitesale.controller.dto;

import com.br.actionsitesale.model.Product;
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
public class ProductResponse {

    @Id
    private String id;
    private String idInternal;
    private String nameProduct;
    private Sizes sizeProduct;
    private BigDecimal valueProduct;
    private UserAuth user;

    public static ProductResponse converter(Product c){
        return ProductResponse.builder()
                .id(c.getId())
                .idInternal(c.getIdInternal())
                .nameProduct(c.getNameProduct())
                .valueProduct(c.getValueProduct())
                .sizeProduct(c.getSizeProduct())
                .user(UserAuth.builder()
                        .numberCorp(c.getUser().getNumberCorp())
                        .build())
                .build();
    }
}