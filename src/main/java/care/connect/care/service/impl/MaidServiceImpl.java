package care.connect.care.service.impl;

import care.connect.care.dto.request.MaidRequestDto;
import care.connect.care.dto.response.MaidResponseDto;
import care.connect.care.exception.ApiException;
import care.connect.care.mapper.MaidMapper;
import care.connect.care.models.Maid;
import care.connect.care.repositories.MaidRepository;
import care.connect.care.service.MaidService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class MaidServiceImpl implements MaidService {

    private final MaidRepository maidRepository;
    private final MaidMapper maidMapper;


    @Override
    public MaidResponseDto createMaid(MaidRequestDto requestDto) throws ApiException {
        log.info("====> Creating New Maid: :{}", requestDto);

        if(maidRepository.existsByPhoneNumber(requestDto.getPhoneNumber())){
            throw new ApiException("Maid already Exist");
        }

        Maid maid = maidMapper.toEntity(requestDto);
        Maid savedMaid = maidRepository.save(maid);
        return maidMapper.toResponseDto(savedMaid);
    }

    @Override
    public MaidResponseDto getMaidById(String id) {

        log.info("====> Fetching Maid by Id: {}", id);
        Maid maid = maidRepository.findById(id)
                .orElseThrow() -> new ApiException("Maid Not Found");

        return maidMapper.toResponseDto(maid);

    }

    @Override
    public Page<MaidService> getAllMaids(Pageable page) {
        log.info("Fetching maids: page {} size {}", page.getPageNumber(), page.getPageSize());

        return maidRepository.findAll(pageable).map(maidMapper::toResponseDto);

    }

    @Override
    public MaidResponseDto updateMaidById(String id, MaidRequestDto requestDto) {
        return null;
    }

    @Override
    public void deleteMaid(String id) throws ApiException {

    }
}
