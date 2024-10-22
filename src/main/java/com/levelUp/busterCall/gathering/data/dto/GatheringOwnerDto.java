package com.levelUp.busterCall.gathering.data.dto;

import com.levelUp.busterCall.gathering.data.entity.GatheringOwnerEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GatheringOwnerDto {

    private Long gatheringOwnerId;

    private Long userId;

    private Long gatheringId;

    public GatheringOwnerEntity toEntity() {
        return GatheringOwnerEntity.builder()
                .gatheringOwnerId(gatheringOwnerId)
                .userId(userId)
                .build();
    }

    public GatheringOwnerDto toDto(GatheringOwnerEntity gatheringOwnerEntity) {
        return GatheringOwnerDto.builder()
                .gatheringOwnerId(gatheringOwnerEntity.getGatheringOwnerId())
                .userId(gatheringOwnerEntity.getUserId())
                .gatheringId(gatheringOwnerEntity.getGatheringEntity().getGatheringId())
                .build();
    }
}

