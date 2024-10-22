package com.levelUp.busterCall.gathering.data.dto;

import com.levelUp.busterCall.gathering.data.entity.GatheringEntity;
import com.levelUp.busterCall.gathering.data.entity.GatheringTimeEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class GatheringTimeDto {

    private Long gatheringTimeId;

    private LocalDateTime sDate;

    private LocalDateTime eDate;

    private Long gatheringId;

    public GatheringTimeEntity toEntity(){
        return GatheringTimeEntity.builder()
                .gatheringTimeId(gatheringTimeId)
                .sDate(sDate)
                .eDate(eDate)
                .build();
    }

    public GatheringTimeDto toDto(GatheringTimeEntity gatheringTimeEntity) {
        return GatheringTimeDto.builder()
                .gatheringTimeId(gatheringTimeEntity.getGatheringTimeId())
                .sDate(gatheringTimeEntity.getSDate())
                .eDate(gatheringTimeEntity.getEDate())
                .gatheringId(gatheringTimeEntity.getGatheringEntity().getGatheringId())
                .build();
    }
}
