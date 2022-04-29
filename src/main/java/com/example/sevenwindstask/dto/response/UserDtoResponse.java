package com.example.sevenwindstask.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoResponse {

    @Schema(name = "id", description = "User id", example = "12345")
    private long id;

    @Schema(name = "firstName", description = "User firstName", example = "Carl")
    private String firstName;

    @Schema(name = "middleName", description = "User middleName", example = "Fridrich")
    private String middleName;

    @Schema(name = "lastName", description = "User lastName", example = "Gauss")
    private String lastName;

    @Schema(name = "email", description = "User email", example = "example@gmail.com")
    private String email;

    @Schema(name = "phoneNumber", description = "User phoneNumber", example = "79835247953")
    private String phoneNumber;

    @Schema(name = "carNumber", description = "User carNumber", example = "X777AM777")
    private String carNumber;

    @Schema(name = "carModel", description = "User carModel", example = "BMW X6 White")
    private String carModel;
}