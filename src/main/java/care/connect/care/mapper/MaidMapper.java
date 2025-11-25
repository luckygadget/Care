package care.connect.care.mapper;

import care.connect.care.dto.request.MaidRequestDto;
import care.connect.care.dto.response.MaidResponseDto;
import care.connect.care.models.Maid;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MaidMapper {


    Maid toEntity(MaidRequestDto dto);

    MaidResponseDto toResponseDto(Maid maid);
}
