package care.connect.care.mapper;


import care.connect.care.dto.request.UserRequestDto;
import care.connect.care.dto.response.UserResponseDto;
import care.connect.care.models.User;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface UserMapper {

    @Mapping(target = "address",
            expression = "java(user.getAddress().isEmpty() ? null : addressMapper.toResponse(user.getAddress().get(0)))")
    UserResponseDto toResponseDto(User user, @Context AddressMapper addressMapper);
}

