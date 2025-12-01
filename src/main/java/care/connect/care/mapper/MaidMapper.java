package care.connect.care.mapper;

import care.connect.care.dto.request.MaidRequestDto;
import care.connect.care.dto.response.MaidResponseDto;
import care.connect.care.models.Maid;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = { AddressMapper.class })
public interface MaidMapper {

    @Mapping(target = "fullName",
            expression = "java(maid.getUser().getFirstName() + \" \" + maid.getUser().getLastName())")
    @Mapping(target = "phoneNumber", source = "user.phoneNumber")
    @Mapping(target = "gender", source = "user.gender")
    @Mapping(target = "bio", source = "user.profileImageUrl")
    @Mapping(target = "skills", expression = "java(java.util.List.of(maid.getSkills()))")
    @Mapping(target = "experienceInYears", expression = "java(Integer.valueOf(maid.getExperience()))")
    @Mapping(target = "totalBookingsCompleted", expression = "java(maid.getBookings().size())")
    @Mapping(target = "address",
            expression = "java(maid.getUser().getAddress().isEmpty() ? null : addressMapper.toResponse(maid.getUser().getAddress().get(0)))")
    @Mapping(target = "createdAt", source = "user.createdAt")
    @Mapping(target = "updatedAt", source = "user.updatedAt")
    MaidResponseDto toResponseDto(Maid maid, @Context AddressMapper addressMapper);
}