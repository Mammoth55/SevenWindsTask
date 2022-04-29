package com.example.sevenwindstask.dto.response;

import com.example.sevenwindstask.model.ParkingPlaceStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkingPlaceDtoResponse {

    @Schema(name = "id", description = "ParkingPlace id", example = "12345")
    private long id;

    @Schema(name = "number", description = "ParkingPlace number", required = true, example = "A55")
    private String number;

    @Schema(name = "status", description = "ParkingPlace status", example = "ENABLED")
    private String status;

    @Schema(name = "price", description = "ParkingPlace price per 1 min", example = "1.25")
    private double price;
}