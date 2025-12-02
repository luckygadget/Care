package care.connect.care.service.impl;

import care.connect.care.dto.request.UserRequestDto;
import care.connect.care.dto.response.UserResponseDto;
import care.connect.care.exception.ApiException;
import care.connect.care.exception.BadRequestException;
import care.connect.care.mapper.AddressMapper;
import care.connect.care.mapper.UserMapper;
import care.connect.care.models.Address;
import care.connect.care.models.User;
import care.connect.care.repositories.UserRepository;
import care.connect.care.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder; // configure BCryptPasswordEncoder bean
    private final AddressMapper addressMapper;     // optional, used if you have it


    @Override
    public UserResponseDto createUser(UserRequestDto requestDto) {

        log.info("====> Creating New User: {} ", requestDto);

        if(requestDto.getFirstName() == null || requestDto.getFirstName().isBlank()){
            throw new BadRequestException("FirstName is required field");
        }

        if(requestDto.getPassword() == null || requestDto.getPassword().isBlank()){
            throw new BadRequestException("Password is required field");
        }
        if(requestDto.getEmail() == null || requestDto.getEmail().isBlank()){
            throw new BadRequestException("Email is required field");
        }

        if (userRepository.existsByEmail(requestDto.getEmail())) {
            throw new BadRequestException("Email already exists");
        }



        User user = new User();

        user.setPhoneNumber(requestDto.getPhoneNumber());
        user.setEmail(requestDto.getEmail());
        user.setFirstName(requestDto.getFirstName());
        user.setLastName(requestDto.getLastName());

        // hash password before saving
        if(requestDto.getPassword() != null && !requestDto.getPassword().isBlank()){
            user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        }

        if(requestDto.getGender() != null){
            user.setGender(requestDto.getGender().name());
        }

        user.setDateOfBirth(requestDto.getDateOfBirth() !=null ? requestDto.getDateOfBirth().atStartOfDay() : null);

        if(requestDto.getRole() != null){
            user.setRole(requestDto.getRole());
        }

        // timestamps
        LocalDateTime now = LocalDateTime.now();
        user.setCreatedAt(now);
//        user.setUpdatedAt(now);

        // handling Addresses

        List<Address> addresses = new ArrayList<>();
        if(requestDto.getAddress() != null){
            var addreq = requestDto.getAddress();
             Address address =  new Address();

             address.setCity(addreq.getCity());
             address.setCountry(addreq.getCountry());
            address.setStreet(addreq.getStreet());
            address.setCountry(addreq.getCountry());
            // your DTO has postalCode but entity has pincode
            address.setPincode(addreq.getPincode());
            address.setUser(user); // set owner
            addresses.add(address);
            address.setAddressId(UUID.randomUUID().toString());

        }

        user.setUserId(UUID.randomUUID().toString());

        user.setAddress(addresses);

        User savedUser = userRepository.save(user);


        return userMapper.toResponseDto(savedUser,addressMapper);

    }

    @Override
    public UserResponseDto getUserById(String id) {

//        log.info("======> Fetching User by Id : {}", id);
//
//        User user = userRepository.findById(id)
//                .orElseThrow() -> new ApiException("User Not Found");
//
//        return userMapper.toResponseDto(user);
        return null;

    }

    @Override
    public Page<UserService> getAllUsers(Pageable page) {

//        log.info("Fetching users: page {} size {}", page.getPageNumber(), page.getPageSize());
//
//        return userRepository.findAll(pageable).map(userMapper::toResponseDto);
        return null;

    }

    @Override
    @Transactional
    public UserResponseDto updateUserById(String id, UserRequestDto requestDto) {

//        log.info("=====> Updating User : {}");
//
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new ApiException("User not found"));
//
//        user.setFirstName(requestDto.getFirstName());
//        user.setPhoneNumber(requestDto.getPhoneNumber());
//        user.setGender(String.valueOf(requestDto.getGender()));
//        user.setUpdatedAt(LocalDateTime.now());
//
//        User updatedUser = userRepository.save(user);
//
//        return userMapper.toResponseDto(updatedUser);
        return null;
    }

    @Override
    public void deleteUser(String id) {
//        log.info("Deleting user: {}", id);
//
//        if (!userRepository.existsById(id)) {
//            throw new ApiException("User not found");
//        }
//
//        userRepository.deleteById(id);

    }
}
