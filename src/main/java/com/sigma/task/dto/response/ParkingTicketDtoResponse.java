package com.sigma.task.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkingTicketDtoResponse {

    @Schema(name = "id", description = "ParkingTicket id", example = "12345")
    private long id;

    @Schema(name = "parkingPlaceDtoResponse", description = "ParkingTicket parkingPlaceDtoResponse")
    private ParkingPlaceDtoResponse parkingPlaceDtoResponse;

    @Schema(name = "userDtoResponse", description = "ParkingTicket userDtoResponse")
    private UserDtoResponse userDtoResponse;

    @Schema(name = "startTime", description = "ParkingTicket startTime", example = "2022-05-01 21:15:00")
    private String startTime;

    @Schema(name = "durationInMinutes", description = "ParkingTicket durationInMinutes", example = "45")
    private int durationInMinutes;

    @Schema(name = "prepaid", description = "ParkingTicket prepaid status", example = "TRUE")
    private boolean prepaid;
}