package care.connect.care.mapper;

import care.connect.care.dto.request.MaidRequestDto;
import care.connect.care.dto.response.MaidResponseDto;
import care.connect.care.models.Maid;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MaidMapper {

    MaidMapper INSTANCE = Mappers.getMapper(MaidMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    Maid toEntity(MaidRequestDto dto);

    MaidResponseDto toResponseDto(Maid maid);
}
