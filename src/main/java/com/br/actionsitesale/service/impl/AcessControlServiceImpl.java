package com.br.actionsitesale.service.impl;

import com.br.actionsitesale.controller.dto.request.ReservationRequest;
import com.br.actionsitesale.controller.dto.response.ReservationResponse;
import com.br.actionsitesale.model.Reservation;
import com.br.actionsitesale.model.enums.StatusReservation;
import com.br.actionsitesale.repository.ReservationControlRepository;
import com.br.actionsitesale.service.AcessControlService;
import com.br.actionsitesale.service.mapper.RegisterProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class AcessControlServiceImpl implements AcessControlService {

    private final RegisterProductMapper mapper;

    private final ModelMapper modelMapper;
    @Autowired
    private ReservationControlRepository repository;

    @Override
    @Transactional
    public List<ReservationResponse> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        List<Reservation> reservations = repository.findAll();
        return Arrays.asList(modelMapper.map(reservations, ReservationResponse[].class));
    }

    @Override
    @Transactional
    public ReservationResponse createReservation(String userLogin, String password, ReservationRequest dto) {
        var reservation = saveReservation(dto);
        reservation.setStatus(StatusReservation.ACTIVE);
        var reservationPersist = this.repository.save(reservation);
        return this.mapper.toAcessResponse(reservationPersist);
    }

    @Override
    @Transactional
    public ReservationResponse cancelReservation(String userLogin, String password, String numberReservation){
        var reservation = repository.findBy(numberReservation);
        reservation.setStatus(StatusReservation.CANCELED);
        final Reservation reservationUpdate = repository.save(reservation);
        return this.mapper.toAcessResponse(reservationUpdate);
    }

    private Reservation saveReservation(ReservationRequest a){
        return Reservation.builder()
                .numberReservation(a.getNumberReservation())
                .numberReservationRoom(a.getNumberReservationRoom())
                .valuePerDayRoom(a.getValuePerDayRoom())
                .nameReservationClient(a.getNameReservationClient())
                .documentNumber(a.getDocumentNumber())
                .documentType(a.getDocumentType())
                .phoneNumber(a.getPhoneNumber())
                .status(a.getStatus())
                .build();
    }

    public AcessControlServiceImpl(RegisterProductMapper mapper, ModelMapper modelMapper) {
        this.mapper = mapper;
        this.modelMapper = modelMapper;
    }
}
