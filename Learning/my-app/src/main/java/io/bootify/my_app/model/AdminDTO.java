package io.bootify.my_app.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AdminDTO {

    private Long adminId;

    @NotNull
    @Size(max = 255)
    private String adminName;

    @NotNull
    @Size(max = 255)
    private String adminEmail;

    @NotNull
    @Size(max = 255)
    private String adminPassword;

}
