package com.example.sevenwindstask.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkingTicketDtoRequest {

    @Schema(name = "parkingPlaceName", description = "ParkingTicket parkingPlaceName", example = "C24")
    private String parkingPlaceNumber;

    @Schema(name = "userCarNumber", description = "ParkingTicket userCarNumber", example = "X777AM777")
    private String userCarNumber;

    @Schema(name = "startTime", description = "ParkingTicket startTime", example = "2022-05-01 21:15:00")
    private String startTime;

    @Schema(name = "durationInMinutes", description = "ParkingTicket durationInMinutes", example = "45")
    private int durationInMinutes;

    @Schema(name = "prepaid", description = "ParkingTicket prepaid status", example = "TRUE")
    private boolean prepaid;
}