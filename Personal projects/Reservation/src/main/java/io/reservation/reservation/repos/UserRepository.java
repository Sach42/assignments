package io.reservation.reservation.repos;

import io.reservation.reservation.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
