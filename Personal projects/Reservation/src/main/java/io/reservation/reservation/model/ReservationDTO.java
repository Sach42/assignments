package io.reservation.reservation.model;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ReservationDTO {

    private Long id;

    @NotNull
    private LocalDate createDate;

    private LocalDate updateDate;

    @NotNull
    private Long user;

}
