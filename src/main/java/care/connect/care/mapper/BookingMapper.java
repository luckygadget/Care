package care.connect.care.mapper;


import care.connect.care.dto.request.BookingRequestDto;
import care.connect.care.dto.response.BookingResponseDto;
import care.connect.care.models.Booking;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.awt.print.Book;

@Mapper(componentModel = "spring", uses = { AddressMapper.class })
public interface BookingMapper {

    @Mapping(target = "userId", source = "user.userId")
    @Mapping(target = "maidId", source = "maid.maidId")
    @Mapping(target = "bookingStartTime", source = "bookingDate")
    @Mapping(target = "bookingEndTime", source = "serviceDate")
    @Mapping(target = "serviceAddress",
            expression = "java(booking.getUser().getAddress().isEmpty() ? null : addressMapper.toResponse(booking.getUser().getAddress().get(0)))")
    @Mapping(target = "createdAt", source = "user.createdAt")
    @Mapping(target = "updatedAt", source = "user.updatedAt")
    BookingResponseDto toResponseDto(Booking booking, @Context AddressMapper addressMapper);
}