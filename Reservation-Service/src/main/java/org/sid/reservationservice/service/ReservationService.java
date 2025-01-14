package org.sid.reservationservice.service;


import org.sid.reservationservice.entity.Reservation;
import org.sid.reservationservice.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation createReservation(Reservation reservation) {
        // Check for overlapping reservations
        List<Reservation> existingReservations = reservationRepository.findByFieldIdAndStartTimeBetween(
                reservation.getFieldId(), reservation.getStartTime(), reservation.getEndTime()
        );

        if (!existingReservations.isEmpty()) {
            throw new IllegalArgumentException("Field is not available for the selected time slot.");
        }

        return reservationRepository.save(reservation);
    }

    public List<Reservation> getReservationsByField(Long fieldId) {
        return reservationRepository.findByFieldIdAndStartTimeBetween(fieldId, LocalDateTime.now(), LocalDateTime.MAX);
    }

    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        Reservation existingReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found."));

        existingReservation.setStartTime(updatedReservation.getStartTime());
        existingReservation.setEndTime(updatedReservation.getEndTime());
        existingReservation.setConfirmed(updatedReservation.isConfirmed());
        return reservationRepository.save(existingReservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
