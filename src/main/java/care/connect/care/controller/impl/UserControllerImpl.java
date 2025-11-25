package care.connect.care.controller.impl;


import care.connect.care.controller.IUserController;
import care.connect.care.dto.request.UserRequestDto;
import care.connect.care.dto.response.UserResponseDto;
import care.connect.care.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserControllerImpl implements IUserController {

    private final UserService userService;


    @Override
    public ResponseEntity<UserResponseDto> createUser(UserRequestDto userRequestDto, HttpServletRequest request) {

        log.info("Received User Create request :::::");
        UserResponseDto userResponseDto = userService.createUser(userRequestDto);

        log.info("=======> User has been created Successfully: {}", userResponseDto.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);


    }

    @Override
    public ResponseEntity<UserResponseDto> getUserById(String id, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<List<UserResponseDto>> getAllUsers(Integer page, Integer size, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<UserResponseDto> updateUserById(String id, UserRequestDto userRequestDto, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteUserById(String id, HttpServletRequest request) {
        return null;
    }
}
