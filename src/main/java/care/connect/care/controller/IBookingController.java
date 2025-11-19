package care.connect.care.controller;


import care.connect.care.dto.request.BookingRequestDto;
import care.connect.care.dto.response.BookingResponseDto;
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

@RequestMapping("/care/bookings")
@Tag(name = "Booking Controller")
public interface IBookingController {

    // Create User
    @Operation(summary = "Create a Booking")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Booking Created",
            content = @Content(schema = @Schema(implementation = BookingResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @PostMapping(consumes = "application/json", produces = "application/json")
    ResponseEntity<BookingResponseDto> createBooking(
            @RequestBody BookingRequestDto bookingRequestDto,
            HttpServletRequest request
    );

    // Get Booking by Id
    @Operation(summary = "Get Booking By Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get Booking By Id",
                    content = @Content(schema = @Schema(implementation = BookingResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Booking Not Found"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @GetMapping(value = "/{bookingId}", produces = "application/json")
    ResponseEntity<BookingResponseDto> getBookingById(
            @PathVariable Long id,
            HttpServletRequest request
    );

    // Get All Bookings
    @Operation(summary = "Get All Bookings")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get Booking By Id",
                    content = @Content(schema = @Schema(implementation = List.class))),
            @ApiResponse(responseCode = "404", description = "Booking Not Found"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @GetMapping(produces = "application/json")
    ResponseEntity<List<BookingResponseDto>> getAllBooking(
            @RequestParam(value = "page" , required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size,
            HttpServletRequest request
    );


    // Get Booking by Id
    @Operation(summary = "Delete Booking By Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get Booking By Id",
                    content = @Content(schema = @Schema(implementation = BookingResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Booking Not Found"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @DeleteMapping(value = "/{bookingId}", produces = "application/json")
    ResponseEntity<BookingResponseDto> deleteBookingById(
            @PathVariable Long id,
            HttpServletRequest request
    );


}
