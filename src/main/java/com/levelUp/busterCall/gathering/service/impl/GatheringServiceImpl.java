package com.levelUp.busterCall.gathering.service.impl;

import com.levelUp.busterCall.gathering.data.dto.*;
import com.levelUp.busterCall.gathering.data.entity.GatheringEntity;
import com.levelUp.busterCall.gathering.repository.GatheringRepository;
import com.levelUp.busterCall.gathering.service.GatheringService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class GatheringServiceImpl implements GatheringService {

    private final GatheringRepository gatheringRepository;

    @Override
    @Transactional
    public GatheringSaveResponseDto saveGathering(GatheringSaveRequestDto gatheringSaveRequestDto) {
        try {
            //GatheringEntity 생성
            GatheringEntity gatheringEntity = gatheringSaveRequestDto.toEntity();

            //SAVE
            GatheringEntity returnGatheringEntity = gatheringRepository.save(gatheringEntity);

            return GatheringSaveResponseDto.builder().build().toDto(returnGatheringEntity);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional
    public List<GatheringSearchResponseDto> getGatheringList(GatheringSearchRequestDto gatheringSearchRequestDto) {
        Page<GatheringEntity> gatheringEntityList;
        Pageable pageable = PageRequest.of(gatheringSearchRequestDto.getPage(), gatheringSearchRequestDto.getSize());
        if(gatheringSearchRequestDto.isUseYn()){
            gatheringEntityList = gatheringRepository.findGatheringByUsing(pageable);
        }else{
            gatheringEntityList = gatheringRepository.findAll(pageable);
        }
        return gatheringEntityList.getContent().stream().map(data -> GatheringSearchResponseDto.builder().build().toDto(data)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public GatheringDetailResponseDto getGatheringDetail(Long gatheringId) {
        Optional<GatheringEntity> gatheringEntity = gatheringRepository.findById(gatheringId);
        if(gatheringEntity.isPresent()){
            return GatheringDetailResponseDto.builder().build().toDto(gatheringEntity.get());
        } else {
            return null;
        }
    }
}
