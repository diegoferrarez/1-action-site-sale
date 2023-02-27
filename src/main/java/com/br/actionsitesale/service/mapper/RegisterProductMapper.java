package com.br.actionsitesale.service.mapper;

import com.br.actionsitesale.controller.dto.response.ReservationResponse;
import com.br.actionsitesale.controller.dto.response.ProductResponse;
import com.br.actionsitesale.model.Reservation;
import com.br.actionsitesale.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterProductMapper {

    private final ObjectMapper mapper;

    @SneakyThrows
    public ProductResponse toResponse(Product product) {
        var json = this.mapper.writeValueAsString(product);
        return this.mapper.readValue(json, ProductResponse.class);
    }

    @SneakyThrows
    public ReservationResponse toAcessResponse(Reservation reservation){
        var json = this.mapper.writeValueAsString(reservation);
        return this.mapper.readValue(json, ReservationResponse.class);
    }
}
