package com.example.sevenwindstask.controller;

import com.example.sevenwindstask.dto.response.UserDtoResponse;
import com.example.sevenwindstask.dto.request.UserDtoRequest;
import com.example.sevenwindstask.model.User;
import com.example.sevenwindstask.service.UserService;
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
@RequestMapping("/api/users")
public class UserController {

    private static final String ID = "id";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Find all Users",
            description = "Returns a list of Users",
            operationId = "usersGetAll")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = UserDtoResponse.class))))})
    @GetMapping("/")
    public ResponseEntity<List<UserDtoResponse>> getAll() {
        return ResponseEntity.ok(userService.getAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList()));
    }

    @Operation(summary = "Find User by Id",
            description = "Returns User, if found",
            operationId = "userGetById")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(schema = @Schema(implementation = UserDtoResponse.class)))})
    @GetMapping("/{id:[\\d]+}")
    public ResponseEntity<UserDtoResponse> getById(@PathVariable(ID) long id) {
        return ResponseEntity.ok(convertToDto(userService.getById(id)));
    }

    @Operation(summary = "Find User by Car Number",
            description = "Returns User, if found",
            operationId = "userGetByCarNumber")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(schema = @Schema(implementation = UserDtoResponse.class)))})
    @GetMapping("/carNumber")
    public ResponseEntity<UserDtoResponse> getByCarNumber(@RequestParam(name = "carNumber", value = "carNumber") String carNumber) {
        return ResponseEntity.ok(convertToDto(userService.getByCarNumber(carNumber)));
    }

    @Operation(summary = "Create new User",
            description = "Returns User, if created",
            operationId = "userCreate")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(schema = @Schema(implementation = UserDtoResponse.class)))})
    @PostMapping("/")
    public ResponseEntity<UserDtoResponse> create(@RequestBody UserDtoRequest request) {
        return ResponseEntity.ok(convertToDto(userService.create(request)));
    }

    @Operation(summary = "Update User by Id",
            description = "Returns User, if updated",
            operationId = "userUpdate")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(schema = @Schema(implementation = UserDtoResponse.class)))})
    @PutMapping("/{id:[\\d]+}")
    public ResponseEntity<UserDtoResponse> update(@PathVariable(ID) long id, @RequestBody UserDtoRequest request) {
        return ResponseEntity.ok(convertToDto(userService.update(id, request)));
    }

    @Operation(summary = "Delete User by Id",
            description = "Returns User, if deleted",
            operationId = "userDelete")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(schema = @Schema(implementation = UserDtoResponse.class)))})
    @DeleteMapping("/{id:[\\d]+}")
    public ResponseEntity<UserDtoResponse> delete(@PathVariable(ID) long id) {
        return ResponseEntity.ok(convertToDto(userService.deleteById(id)));
    }

    private UserDtoResponse convertToDto(User user) {
        return UserDtoResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .middleName(user.getMiddleName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .carNumber(user.getCarNumber())
                .carModel(user.getCarModel())
                .build();
    }
}