package com.br.actionsitesale.service;

import com.br.actionsitesale.controller.dto.request.ReservationRequest;
import com.br.actionsitesale.controller.dto.response.ReservationResponse;

import java.util.List;

public interface AcessControlService {

    List<ReservationResponse> findAll();
    ReservationResponse createReservation(String userLogin, String password, ReservationRequest request);
    ReservationResponse cancelReservation(String userLogin, String password, String numberReservation);
    List<ReservationResponse> download();
}
