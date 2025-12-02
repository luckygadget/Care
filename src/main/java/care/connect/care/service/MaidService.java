package care.connect.care.service;

import care.connect.care.dto.request.MaidRequestDto;
import care.connect.care.dto.request.UserRequestDto;
import care.connect.care.dto.response.MaidResponseDto;
import care.connect.care.dto.response.UserResponseDto;
import care.connect.care.exception.ApiException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

public interface MaidService {

    MaidResponseDto createMaid(MaidRequestDto requestDto);

    MaidResponseDto getMaidById(String id);

    Page<MaidService> getAllMaids(Pageable page);

    MaidResponseDto updateMaidById(String id, MaidRequestDto requestDto);

    void deleteMaid(String id);
}
