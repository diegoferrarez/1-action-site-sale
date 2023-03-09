package com.br.actionsitesale.controller;

import com.br.actionsitesale.controller.dto.request.ReservationRequest;
import com.br.actionsitesale.controller.dto.response.ReservationResponse;
import com.br.actionsitesale.model.Reservation;
import com.br.actionsitesale.service.AcessControlService;
import com.br.actionsitesale.utils.UserConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/rooms/acess-control/")
public class ReservationController {

    @Autowired
    private AcessControlService acessService;

    @GetMapping("find/all-reservation")
    @ResponseStatus(HttpStatus.OK)
    public List<ReservationResponse> getAllReservation(){
        return acessService.findAll();
    }

    @PostMapping("insert/reservation")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationResponse createReservationRoom(@RequestHeader(name = UserConstants.USER_SIGN_HEADER)String userLogin,
                                                     @RequestHeader(name = UserConstants.USER_PASS_HEADER)String password,
                                                     @RequestBody ReservationRequest request){
        return acessService.createReservation(userLogin, password, request);
    }

    @PatchMapping("update/{numberReservation}/reservation")
    public ReservationResponse cancelReservationRoom(@RequestHeader(name = UserConstants.USER_SIGN_HEADER)String userLogin,
                                                     @RequestHeader(name = UserConstants.USER_PASS_HEADER)String password,
                                                     @PathVariable String numberReservation){
        return acessService.cancelReservation(userLogin, password, numberReservation);
    }

    @GetMapping("sendReport")
    @ResponseStatus(HttpStatus.OK)
    public List<ReservationResponse> downloadReport(){
        return acessService.download();
    }
}
