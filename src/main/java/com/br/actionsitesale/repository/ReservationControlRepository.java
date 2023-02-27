package com.br.actionsitesale.repository;

import com.br.actionsitesale.controller.dto.response.ReservationResponse;
import com.br.actionsitesale.model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationControlRepository extends MongoRepository<Reservation, String> {

//    @Query("{ 'numberReservation' : ?0 }")
    @Query("SELECT t FROM AcessControlRooms t WHERE t.numberReservation")
    Reservation findBy(String numberReservation);
}
