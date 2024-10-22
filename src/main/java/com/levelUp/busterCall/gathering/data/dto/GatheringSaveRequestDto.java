package com.levelUp.busterCall.gathering.data.dto;

import com.levelUp.busterCall.gathering.data.entity.GatheringEntity;
import com.levelUp.busterCall.gathering.data.entity.GatheringOwnerEntity;
import com.levelUp.busterCall.gathering.data.entity.GatheringTimeEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GatheringSaveRequestDto{
    private String name;
    private String contents;
    private Long userId;

    public GatheringEntity toEntity(){
        GatheringEntity gatheringEntity = GatheringEntity.builder()
                .name(this.name)
                .contents(this.contents)
                .build();

        GatheringOwnerEntity gatheringOwnerEntity = GatheringOwnerEntity.builder()
                .userId(this.userId)
                .gatheringEntity(gatheringEntity)
                .build();

        LocalDateTime now = LocalDateTime.now();
        GatheringTimeEntity gatheringTimeEntity = GatheringTimeEntity.builder()
                .gatheringEntity(gatheringEntity)
                .sDate(now)
                .eDate(now.plusMinutes(10))
                .build();

        gatheringEntity.setGatheringOwnerEntity(gatheringOwnerEntity);
        gatheringEntity.setGatheringTimeEntity(gatheringTimeEntity);

        return gatheringEntity;
    }
}
