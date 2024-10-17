package com.levelUp.busterCall.gathering.service.impl;

import com.levelUp.busterCall.gathering.data.dto.GatheringDto;
import com.levelUp.busterCall.gathering.data.dto.GatheringOwnerDto;
import com.levelUp.busterCall.gathering.data.dto.GatheringTimeDto;
import com.levelUp.busterCall.gathering.data.entity.GatheringEntity;
import com.levelUp.busterCall.gathering.data.entity.GatheringOwnerEntity;
import com.levelUp.busterCall.gathering.data.entity.GatheringTimeEntity;
import com.levelUp.busterCall.gathering.repository.GatheringRepository;
import com.levelUp.busterCall.gathering.service.GatheringService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GatheringServiceImpl implements GatheringService {

    private final GatheringRepository gatheringRepository;

    @Override
    @Transactional
    public GatheringDto regGathering(GatheringDto gatheringDto) {

        //GATHERING TABLE
        GatheringEntity gatheringEntity = gatheringDto.toEntity();

        //GATHERING_OWNER TABLE
        GatheringOwnerEntity gatheringOwnerEntity = GatheringOwnerEntity.builder()
                .userId(gatheringDto.getGatheringOwnerDto().getUserId())
                .gatheringEntity(gatheringEntity)
                .build();
        gatheringEntity.setGatheringOwnerEntity(gatheringOwnerEntity);

        //GATHERING_TIME TABLE
        LocalDateTime now = LocalDateTime.now();
        GatheringTimeEntity gatheringTimeEntity = GatheringTimeEntity.builder()
                .sDate(now)
                .eDate(now.plusMinutes(10))
                .gatheringEntity(gatheringEntity)
                .build();
        gatheringEntity.setGatheringTimeEntity(gatheringTimeEntity);

        //SAVE
        GatheringEntity returnGatheringEntity = gatheringRepository.save(gatheringEntity);

        return gatheringDto;
    }

    @Override
    @Transactional
    public List<GatheringDto> getGatheringList(GatheringDto gatheringDto) {
        List<GatheringEntity> gatheringEntityList = gatheringRepository.findAll();
        List<GatheringDto> gatheringDtoList = new ArrayList<>();

        for(GatheringEntity gatheringEntity : gatheringEntityList){
            GatheringDto transGatheringDto = GatheringDto.builder()
                    .gatheringId(gatheringEntity.getGatheringId())
                    .name(gatheringEntity.getName())
                    .contents(gatheringEntity.getContents())
                    .gatheringOwnerDto(gatheringEntity.getGatheringOwnerEntity() == null ? null : GatheringOwnerDto.builder().build().toDto(gatheringEntity.getGatheringOwnerEntity()))
                    .gatheringTimeDto(gatheringEntity.getGatheringTimeEntity() == null ? null : GatheringTimeDto.builder().build().toDto(gatheringEntity.getGatheringTimeEntity()))
                    .build();

            gatheringDtoList.add(transGatheringDto);
        }

        return gatheringDtoList;
    }

    @Override
    @Transactional
    public List<GatheringDto> getUsingGatheringList(){
        LocalDateTime now = LocalDateTime.now();
        List<GatheringEntity> gatheringEntityList = gatheringRepository.findByGatheringTimeEntity_sDateBeforeAndGatheringTimeEntity_eDateAfter(now, now);
        List<GatheringDto> gatheringDtoList = new ArrayList<>();

        for(GatheringEntity gatheringEntity : gatheringEntityList){
            GatheringDto transGatheringDto = GatheringDto.builder()
                    .gatheringId(gatheringEntity.getGatheringId())
                    .name(gatheringEntity.getName())
                    .contents(gatheringEntity.getContents())
                    .gatheringOwnerDto(gatheringEntity.getGatheringOwnerEntity() == null ? null : GatheringOwnerDto.builder().build().toDto(gatheringEntity.getGatheringOwnerEntity()))
                    .gatheringTimeDto(gatheringEntity.getGatheringTimeEntity() == null ? null : GatheringTimeDto.builder().build().toDto(gatheringEntity.getGatheringTimeEntity()))
                    .build();

            gatheringDtoList.add(transGatheringDto);
        }

        return gatheringDtoList;
    }
}
