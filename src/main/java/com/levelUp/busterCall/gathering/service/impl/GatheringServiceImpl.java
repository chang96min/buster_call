package com.levelUp.busterCall.gathering.service.impl;

import com.levelUp.busterCall.gathering.data.dto.GatheringDto;
import com.levelUp.busterCall.gathering.data.entity.GatheringEntity;
import com.levelUp.busterCall.gathering.repository.GatheringRepository;
import com.levelUp.busterCall.gathering.service.GatheringService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class GatheringServiceImpl implements GatheringService {

    private final GatheringRepository gatheringRepository;

    @Override
    public GatheringDto regGathering(GatheringDto gatheringDto) {

        //DTO -> Entity
        GatheringEntity gatheringEntity = GatheringEntity.builder()
                .gatheringId(gatheringDto.getGatheringId())
                .name(gatheringDto.getName())
                .contents(gatheringDto.getContents())
                .views(gatheringDto.getViews())
                .build();

        //SAVE
        GatheringEntity returnGatheringEntity = gatheringRepository.save(gatheringEntity);


        //Return Entity -> DTO
        GatheringDto returnGatheringDto = GatheringDto.builder()
                .gatheringId(returnGatheringEntity.getGatheringId())
                .name(returnGatheringEntity.getName())
                .contents(returnGatheringEntity.getContents())
                .views(returnGatheringEntity.getViews())
                .build();


        return returnGatheringDto;
    }
}
