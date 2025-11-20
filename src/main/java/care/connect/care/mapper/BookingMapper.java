package care.connect.care.mapper;


import care.connect.care.dto.request.BookingRequestDto;
import care.connect.care.dto.response.BookingResponseDto;
import care.connect.care.models.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.awt.print.Book;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "maid", ignore = true)  // set in service
    @Mapping(target = "user", ignore = true)  // set in service
    Booking toEntity(BookingRequestDto dto);

    BookingResponseDto toResponseDto(Booking booking);
}
