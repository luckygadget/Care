package care.connect.care.service.impl;

import care.connect.care.dto.request.UserRequestDto;
import care.connect.care.dto.response.UserResponseDto;
import care.connect.care.exception.ApiException;
import care.connect.care.mapper.UserMapper;
import care.connect.care.models.User;
import care.connect.care.repositories.UserRepository;
import care.connect.care.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public UserResponseDto createUser(UserRequestDto requestDto) throws ApiException {

        log.info("====> Creating New User: {} ", requestDto);

        if(userRepository.existsByEmail(requestDto.getEmail())){
            throw new ApiException("Email already Exist");
        }

        User user = userMapper.toEntity(requestDto);

        User savedUser = userRepository.save(user);

        return userMapper.toResponseDto(savedUser);

    }

    @Override
    public UserResponseDto getUserById(String id) {

        log.info("======> Fetching User by Id : {}", id);

        User user = userRepository.findById(id)
                .orElseThrow() -> new ApiException("User Not Found");

        return userMapper.toResponseDto(user);
    }

    @Override
    public Page<UserService> getAllUsers(Pageable page) {

        log.info("Fetching users: page {} size {}", page.getPageNumber(), page.getPageSize());

        return userRepository.findAll(pageable).map(userMapper::toResponseDto);
    }

    @Override
    @Transactional
    public UserResponseDto updateUserById(String id, UserRequestDto requestDto) {

        log.info("=====> Updating User : {}");

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ApiException("User not found"));

        user.setFirstName(requestDto.getFirstName());
        user.setPhoneNumber(requestDto.getPhoneNumber());
        user.setGender(String.valueOf(requestDto.getGender()));
        user.setUpdatedAt(LocalDateTime.now());

        User updatedUser = userRepository.save(user);

        return userMapper.toResponseDto(updatedUser);
    }

    @Override
    public void deleteUser(String id) throws ApiException {
        log.info("Deleting user: {}", id);

        if (!userRepository.existsById(id)) {
            throw new ApiException("User not found");
        }

        userRepository.deleteById(id);

    }
}
