package com.br.actionsitesale;

import com.br.actionsitesale.model.Reservation;
import com.br.actionsitesale.model.enums.Documents;
import com.br.actionsitesale.model.enums.StatusReservation;
import com.br.actionsitesale.service.impl.CriaArquivoExcel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CriaArquivoExcelTest {

    private final List<Reservation> reservations = new ArrayList<>();

//    @BeforeEach
//    public void setup() {
//        reservations.add(new Reservation("10", 10, 100, "Diego Sacramento", BigDecimal.valueOf(450),"0000000","010101", Documents.RG, StatusReservation.ACTIVE));
//        reservations.add(new Reservation("11", 11, 105, "Sayra Sacramento", BigDecimal.valueOf(510),"1111111","020202", Documents.RG, StatusReservation.ACTIVE));
//        reservations.add(new Reservation("12", 12, 109, "Alex Sacramento", BigDecimal.valueOf(610),"2222222","030303", Documents.RG, StatusReservation.ACTIVE));
//        reservations.add(new Reservation("13", 13, 110, "Katia Sacramento", BigDecimal.valueOf(710),"33333333","040404", Documents.RG, StatusReservation.ACTIVE));
//
//    }


    @Test
    void criarArquivo() {
        var criaArquivoExcel = new CriaArquivoExcel();
        assertNotNull(criaArquivoExcel);
        criaArquivoExcel.criarArquivo("clientes.xlsx", reservations);
    }

    @Test
    void criarArquivoMongo() {
        var criaArquivoExcel = new CriaArquivoExcel();
        assertNotNull(criaArquivoExcel);
        criaArquivoExcel.criarArquivo("clientesReservation.xlsx", reservations);
    }
}