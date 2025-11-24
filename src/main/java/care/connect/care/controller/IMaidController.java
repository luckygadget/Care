package care.connect.care.controller;

import care.connect.care.dto.request.MaidRequestDto;
import care.connect.care.dto.request.UserRequestDto;
import care.connect.care.dto.response.MaidResponseDto;
import care.connect.care.dto.response.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/care/maids")
public interface IMaidController {

    // create <Maid>
    @Operation(summary = "create a Maid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Maid Created",
                    content = @Content(schema = @Schema(implementation = MaidRequestDto.class))),
            @ApiResponse(responseCode = "400", description = "Validation Failed"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @PostMapping(consumes = "application/json", produces = "application/json")
    ResponseEntity<MaidResponseDto> createMaid(
            @RequestBody MaidRequestDto MaidRequestDto, HttpServletRequest request
    );


    // Get Maid By ID
    @Operation(summary = "Get Maid By ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = MaidResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Maid Not Found"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @GetMapping(value = "/{MaidId}", produces = "application/json")
    ResponseEntity<MaidResponseDto> getMaidById(
            @PathVariable String id,
            HttpServletRequest request
    );

    // Get all Maids with Pagination
    @Operation(summary = "Get all Maids")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = List.class))),
            @ApiResponse(responseCode = "404", description = "Maid Not Found"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @GetMapping(produces = "application/json")
    ResponseEntity<List<MaidResponseDto>> getAllMaids(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size,
            HttpServletRequest request
    );


    @Operation(summary = "Update Maid Record")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "updated",
                    content = @Content(schema = @Schema(implementation = MaidResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Maid Not Found"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @PutMapping(value = "/{MaidId}", consumes = "application/json", produces = "application/json")
    ResponseEntity<MaidResponseDto> updateMaidById(
            @PathVariable String id,
            @RequestBody MaidRequestDto MaidRequestDto,
            HttpServletRequest request
    );

    @Operation(summary = "Delete Maid Record")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted",
                    content = @Content(schema = @Schema(implementation = MaidResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Maid Not Found"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @DeleteMapping(value = "/{MaidId}")
    ResponseEntity<Void> deleteMaidById(
            @PathVariable String id,
            HttpServletRequest request
    );


}
