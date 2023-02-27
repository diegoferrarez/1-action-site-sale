package com.br.actionsitesale.controller.dto.request;

import com.br.actionsitesale.model.enums.Documents;
import com.br.actionsitesale.model.enums.StatusReservation;
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
public class ReservationRequest {

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

}
