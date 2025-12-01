package care.connect.care.mapper;

import care.connect.care.dto.response.AddressResponseDto;
import care.connect.care.models.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressResponseDto toResponse(Address address);
}

