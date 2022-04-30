package com.example.sevenwindstask.controller;

import com.example.sevenwindstask.dto.request.ParkingTicketDtoRequest;
import com.example.sevenwindstask.dto.response.ParkingTicketDtoResponse;
import com.example.sevenwindstask.model.ParkingTicket;
import com.example.sevenwindstask.service.ParkingTicketService;
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

import static com.example.sevenwindstask.controller.ParkingPlaceController.convertParkingPlaceToDto;
import static com.example.sevenwindstask.controller.UserController.convertUserToDto;

@RestController
@RequestMapping("/api/parkingTickets")
public class ParkingTicketController {

    private static final String ID = "id";

    private final ParkingTicketService parkingTicketService;

    public ParkingTicketController(ParkingTicketService parkingTicketService) {
        this.parkingTicketService = parkingTicketService;
    }

    @Operation(summary = "Find all ParkingTickets",
            description = "Returns a list of ParkingTickets",
            operationId = "parkingTicketsGetAll")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ParkingTicketDtoResponse.class))))})
    @GetMapping("/")
    public ResponseEntity<List<ParkingTicketDtoResponse>> getAll() {
        return ResponseEntity.ok(parkingTicketService.getAll().stream()
                .map(ParkingTicketController::convertParkingTicketToDto)
                .collect(Collectors.toList()));
    }

    @Operation(summary = "Find ParkingTicket by Id",
            description = "Returns ParkingTicket, if found",
            operationId = "parkingTicketGetById")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(schema = @Schema(implementation = ParkingTicketDtoResponse.class)))})
    @GetMapping("/{id:\\d+}")
    public ResponseEntity<ParkingTicketDtoResponse> getById(@PathVariable(ID) long id) {
        return ResponseEntity.ok(convertParkingTicketToDto(parkingTicketService.getById(id)));
    }

    @Operation(summary = "Find ParkingTicket by UserCarNumber",
            description = "Returns ParkingTicket, if found",
            operationId = "parkingTicketGetByUserCarNumber")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(schema = @Schema(implementation = ParkingTicketDtoResponse.class)))})
    @GetMapping("/userCarNumber")
    public ResponseEntity<ParkingTicketDtoResponse> getByNumber(
            @RequestParam(name = "number", value = "number") String number) {
        return ResponseEntity.ok(convertParkingTicketToDto(parkingTicketService.getByUserCarNumber(number)));
    }

    @Operation(summary = "Find ParkingTicket by parkingPlaceNumber",
            description = "Returns ParkingTicket, if found",
            operationId = "parkingTicketGetByParkingPlaceNumber")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(schema = @Schema(implementation = ParkingTicketDtoResponse.class)))})
    @GetMapping("/parkingPlaceNumber")
    public ResponseEntity<ParkingTicketDtoResponse> getByParkingPlaceNumber(
            @RequestParam(name = "number", value = "number") String number) {
        return ResponseEntity.ok(convertParkingTicketToDto(parkingTicketService.getByParkingPlaceNumber(number)));
    }

    @Operation(summary = "Create new ParkingTicket",
            description = "Returns ParkingTicket, if created",
            operationId = "parkingTicketCreate")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(schema = @Schema(implementation = ParkingTicketDtoResponse.class)))})
    @PostMapping("/")
    public ResponseEntity<ParkingTicketDtoResponse> create(@RequestBody ParkingTicketDtoRequest request) {
        return ResponseEntity.ok(convertParkingTicketToDto(parkingTicketService.create(0L, request)));
    }

    @Operation(summary = "Update ParkingTicket by Id",
            description = "Returns ParkingTicket, if updated",
            operationId = "parkingTicketUpdate")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(schema = @Schema(implementation = ParkingTicketDtoResponse.class)))})
    @PutMapping("/{id:\\d+}")
    public ResponseEntity<ParkingTicketDtoResponse> update(@PathVariable(ID) long id,
                                                           @RequestBody ParkingTicketDtoRequest request) {
        return ResponseEntity.ok(convertParkingTicketToDto(parkingTicketService.update(id, request)));
    }

    @Operation(summary = "Delete ParkingTicket by Id",
            description = "Returns ParkingTicket, if deleted",
            operationId = "parkingTicketDelete")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(schema = @Schema(implementation = ParkingTicketDtoResponse.class)))})
    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<ParkingTicketDtoResponse> delete(@PathVariable(ID) long id) {
        return ResponseEntity.ok(convertParkingTicketToDto(parkingTicketService.deleteById(id)));
    }

    private static ParkingTicketDtoResponse convertParkingTicketToDto(ParkingTicket parkingTicket) {
        return ParkingTicketDtoResponse.builder()
                .id(parkingTicket.getId())
                .parkingPlaceDtoResponse(convertParkingPlaceToDto(parkingTicket.getParkingPlace()))
                .userDtoResponse(convertUserToDto(parkingTicket.getUser()))
                .startTime(parkingTicket.getStartTime().toString())
                .durationInMinutes(parkingTicket.getDurationInMinutes())
                .prepaid(parkingTicket.isPrepaid())
                .build();
    }
}