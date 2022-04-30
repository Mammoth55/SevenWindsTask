package com.example.sevenwindstask.controller;

import com.example.sevenwindstask.dto.request.ParkingPlaceDtoRequest;
import com.example.sevenwindstask.dto.response.ParkingPlaceDtoResponse;
import com.example.sevenwindstask.model.ParkingPlace;
import com.example.sevenwindstask.service.ParkingPlaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/parkingPlaces")
public class ParkingPlaceController {

    private static final String ID = "id";

    private final ParkingPlaceService parkingPlaceService;

    public ParkingPlaceController(ParkingPlaceService parkingPlaceService) {
        this.parkingPlaceService = parkingPlaceService;
    }

    @Operation(summary = "Find all ParkingPlaces",
            description = "Returns a list of ParkingPlaces",
            operationId = "parkingPlacesGetAll")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ParkingPlaceDtoResponse.class))))})
    @GetMapping("/")
    public ResponseEntity<List<ParkingPlaceDtoResponse>> getAll() {
        return ResponseEntity.ok(parkingPlaceService.getAll().stream()
                .map(ParkingPlaceController::convertParkingPlaceToDto)
                .collect(Collectors.toList()));
    }

    @Operation(summary = "Find ParkingPlace by Id",
            description = "Returns ParkingPlace, if found",
            operationId = "parkingPlaceGetById")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(schema = @Schema(implementation = ParkingPlaceDtoResponse.class)))})
    @GetMapping("/{id:\\d+}")
    public ResponseEntity<ParkingPlaceDtoResponse> getById(@PathVariable(ID) long id) {
        return ResponseEntity.ok(convertParkingPlaceToDto(parkingPlaceService.getById(id)));
    }

    @Operation(summary = "Find ParkingPlace by Number",
            description = "Returns ParkingPlace, if found",
            operationId = "parkingPlaceGetByNumber")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(schema = @Schema(implementation = ParkingPlaceDtoResponse.class)))})
    @GetMapping("/number")
    public ResponseEntity<ParkingPlaceDtoResponse> getByNumber(@RequestParam(name = "number", value = "number") String number) {
        return ResponseEntity.ok(convertParkingPlaceToDto(parkingPlaceService.getByNumber(number)));
    }

    @Operation(summary = "Create new ParkingPlace",
            description = "Returns ParkingPlace, if created",
            operationId = "parkingPlaceCreate")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(schema = @Schema(implementation = ParkingPlaceDtoResponse.class)))})
    @PostMapping("/")
    public ResponseEntity<ParkingPlaceDtoResponse> create(@RequestBody ParkingPlaceDtoRequest request) {
        return ResponseEntity.ok(convertParkingPlaceToDto(parkingPlaceService.create(0L, request)));
    }

    @Operation(summary = "Update ParkingPlace by Id",
            description = "Returns ParkingPlace, if updated",
            operationId = "parkingPlaceUpdate")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(schema = @Schema(implementation = ParkingPlaceDtoResponse.class)))})
    @PutMapping("/{id:\\d+}")
    public ResponseEntity<ParkingPlaceDtoResponse> update(@PathVariable(ID) long id, @RequestBody ParkingPlaceDtoRequest request) {
        return ResponseEntity.ok(convertParkingPlaceToDto(parkingPlaceService.update(id, request)));
    }

    @Operation(summary = "Delete ParkingPlace by Id",
            description = "Returns ParkingPlace, if deleted",
            operationId = "parkingPlaceDelete")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(schema = @Schema(implementation = ParkingPlaceDtoResponse.class)))})
    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<ParkingPlaceDtoResponse> delete(@PathVariable(ID) long id) {
        return ResponseEntity.ok(convertParkingPlaceToDto(parkingPlaceService.deleteById(id)));
    }

    static ParkingPlaceDtoResponse convertParkingPlaceToDto(ParkingPlace parkingPlace) {
        return ParkingPlaceDtoResponse.builder()
                .id(parkingPlace.getId())
                .number(parkingPlace.getNumber())
                .status(parkingPlace.getStatus().name())
                .price(parkingPlace.getPrice())
                .build();
    }
}