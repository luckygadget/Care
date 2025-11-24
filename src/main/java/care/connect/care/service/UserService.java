package care.connect.care.service;

import care.connect.care.dto.request.UserRequestDto;
import care.connect.care.dto.response.UserResponseDto;
import care.connect.care.exception.ApiException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserResponseDto createUser(UserRequestDto requestDto) throws ApiException;

    UserResponseDto getUserById(String id);

    Page<UserService> getAllUsers(Pageable page);

    UserResponseDto updateUserById(String id, UserRequestDto requestDto);

    void deleteUser(String id) throws ApiException;

}
