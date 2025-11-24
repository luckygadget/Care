package care.connect.care.controller;


import care.connect.care.dto.request.UserRequestDto;
import care.connect.care.dto.response.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/care/users")
@Tag(name = "User Controller")
public interface IUserController {

    // create User
    @Operation(summary = "create a User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User Created",
                    content = @Content(schema = @Schema(implementation = UserRequestDto.class))),
            @ApiResponse(responseCode = "400", description = "Validation Failed"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @PostMapping(consumes = "application/json", produces = "application/json")
    ResponseEntity<UserResponseDto> createUser(
        @RequestBody UserRequestDto userRequestDto, HttpServletRequest request
    );


    // Get User By ID
    @Operation(summary = "Get User By ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = UserResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "User Not Found"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @GetMapping(value = "/{userId}", produces = "application/json")
    ResponseEntity<UserResponseDto> getUserById(
            @PathVariable String id,
            HttpServletRequest request
    );

    // Get all Users with Pagination
    @Operation(summary = "Get all Users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = List.class))),
            @ApiResponse(responseCode = "404", description = "User Not Found"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @GetMapping(produces = "application/json")
    ResponseEntity<List<UserResponseDto>> getAllUsers(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size,
            HttpServletRequest request
    );


    @Operation(summary = "Update User Record")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "updated",
                    content = @Content(schema = @Schema(implementation = UserResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "User Not Found"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @PutMapping(value = "/{userId}", consumes = "application/json", produces = "application/json")
    ResponseEntity<UserResponseDto> updateUserById(
            @PathVariable String id,
            @RequestBody UserRequestDto userRequestDto,
            HttpServletRequest request
    );

    @Operation(summary = "Delete User Record")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted",
                    content = @Content(schema = @Schema(implementation = UserResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "User Not Found"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @DeleteMapping(value = "/{userId}")
    ResponseEntity<Void> deleteUserById(
            @PathVariable String id,
            HttpServletRequest request
    );



}
