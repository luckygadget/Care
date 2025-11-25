package care.connect.care.mapper;


import care.connect.care.dto.request.UserRequestDto;
import care.connect.care.dto.response.UserResponseDto;
import care.connect.care.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface UserMapper {



    User toEntity(UserRequestDto dto);

    UserResponseDto toResponseDto(User user);
}
