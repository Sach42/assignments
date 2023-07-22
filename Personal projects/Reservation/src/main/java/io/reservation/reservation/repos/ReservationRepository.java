package io.reservation.reservation.repos;

import io.reservation.reservation.domain.Reservation;
import io.reservation.reservation.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Reservation findFirstByUser(User user);

}
