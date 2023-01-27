package com.br.actionsitesale.service.mapper;

import com.br.actionsitesale.controller.dto.ProductResponse;
import com.br.actionsitesale.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RegisterProductMapper {

    private final ObjectMapper mapper;

    @SneakyThrows
    public ProductResponse toResponse(Product product) {
        var json = this.mapper.writeValueAsString(product);
        return this.mapper.readValue(json, ProductResponse.class);
    }
}
