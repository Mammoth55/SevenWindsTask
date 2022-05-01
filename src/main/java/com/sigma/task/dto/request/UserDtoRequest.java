package com.sigma.task.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.Column;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoRequest {

    @Schema(name = "firstName", description = "User firstName", required = true, example = "Carl")
    private String firstName;

    @Schema(name = "middleName", description = "User middleName", example = "Fridrich")
    private String middleName;

    @Schema(name = "lastName", description = "User lastName", example = "Gauss")
    private String lastName;

    @Schema(name = "email", description = "User email", required = true, example = "example@gmail.com")
    private String email;

    @Schema(name = "phoneNumber", description = "User phoneNumber", required = true, example = "79835247953")
    private String phoneNumber;

    @Schema(name = "carNumber", description = "User carNumber", required = true, example = "X777AM777")
    private String carNumber;

    @Schema(name = "carModel", description = "User carModel", required = true, example = "BMW X6 White")
    private String carModel;
}