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


    Booking toEntity(BookingRequestDto dto);

    BookingResponseDto toResponseDto(Booking booking);
}
