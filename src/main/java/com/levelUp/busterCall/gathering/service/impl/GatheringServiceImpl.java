package com.levelUp.busterCall.gathering.service.impl;

import com.levelUp.busterCall.gathering.data.dto.*;
import com.levelUp.busterCall.gathering.data.entity.GatheringEntity;
import com.levelUp.busterCall.gathering.repository.GatheringRepository;
import com.levelUp.busterCall.gathering.service.GatheringService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
        if(gatheringSearchRequestDto.isUseYn()){
           gatheringEntityList = new PageImpl<>(gatheringRepository.findGatheringByUsing(PageRequest.of(gatheringSearchRequestDto.getPage(), gatheringSearchRequestDto.getSize())));
        }else{
            gatheringEntityList = gatheringRepository.findAll(PageRequest.of(gatheringSearchRequestDto.getPage(), gatheringSearchRequestDto.getSize()));
        }
        return gatheringEntityList.getContent().stream().map(data -> GatheringSearchResponseDto.builder().build().toDto(data)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public GatheringDto getGatheringDetail(GatheringDto gatheringDto) {
        Optional<GatheringEntity> gatheringEntity = gatheringRepository.findById(gatheringDto.getGatheringId());

        return gatheringEntity.map(data -> new GatheringDto().toDto(data)).orElse(null);
    }
}
