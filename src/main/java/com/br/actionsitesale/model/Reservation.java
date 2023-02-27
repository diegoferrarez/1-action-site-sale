package com.br.actionsitesale.model;

import com.br.actionsitesale.model.enums.Documents;
import com.br.actionsitesale.model.enums.StatusReservation;
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
@Document(collection = "AcessControlRooms")
public class Reservation {

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
