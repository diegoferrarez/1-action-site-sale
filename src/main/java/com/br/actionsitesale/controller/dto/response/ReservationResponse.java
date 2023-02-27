package com.br.actionsitesale.controller.dto.response;

import com.br.actionsitesale.model.Product;
import com.br.actionsitesale.model.Reservation;
import com.br.actionsitesale.model.UserAuth;
import com.br.actionsitesale.model.enums.Documents;
import com.br.actionsitesale.model.enums.StatusReservation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponse {

    @Id
    private String id;
    private Integer numberReservation;
    private Integer numberReservationRoom;
    private String nameReservationClient;
    private BigDecimal valuePerDayRoom;
    private String phoneNumber;
    private String documentNumber;
    private Documents documentType;
    private StatusReservation status;

    public static ReservationResponse converter(Reservation c){
        return ReservationResponse.builder()
                .id(c.getId())
                .numberReservation(c.getNumberReservation())
                .numberReservationRoom(c.getNumberReservationRoom())
                .nameReservationClient(c.getNameReservationClient())
                .valuePerDayRoom(c.getValuePerDayRoom())
                .phoneNumber(c.getPhoneNumber())
                .documentNumber(c.getDocumentNumber())
                .documentType(c.getDocumentType())
                .status(c.getStatus())
                .build();
    }

    public ReservationResponse(HttpStatus badRequest) {
    }

}
