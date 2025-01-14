package org.sid.reservationservice.repository;


import org.sid.reservationservice.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByFieldIdAndStartTimeBetween(Long fieldId, LocalDateTime start, LocalDateTime end);
}
