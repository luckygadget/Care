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

        try{
            log.info("post call create Users in try block body : ", userRequestDto);
            UserResponseDto response = userService.createUser();
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        }catch (ApiException  e){

        }
        return null;
    }

    @Override
    public ResponseEntity<UserResponseDto> getUserById(Long id, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<List<UserResponseDto>> getAllUsers(Integer page, Integer size, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<UserResponseDto> updateUserById(Long id, UserRequestDto userRequestDto, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteUserById(Long id, HttpServletRequest request) {
        return null;
    }
}
