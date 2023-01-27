package com.br.actionsitesale.model;

import com.br.actionsitesale.model.enums.Sizes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "productStoreSale")
public class Product {

    @Id
    private String id;
    private String idInternal;
    private String nameProduct;
    private Sizes sizeProduct;
    private BigDecimal valueProduct;
    private UserAuth user;
}