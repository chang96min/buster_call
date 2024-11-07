package com.levelUp.busterCall.gathering.data.dto;

import com.levelUp.busterCall.gathering.data.entity.GatheringEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GatheringSearchResponseDto {
    private Long gatheringId;
    private String name;
    private String contents;
    private Long ownerId;
    private String ownerName;
    private LocalDateTime sDate;
    private LocalDateTime eDate;

    public GatheringSearchResponseDto toDto(GatheringEntity gatheringEntity) {
        return GatheringSearchResponseDto.builder()
                .gatheringId(gatheringEntity.getGatheringId())
                .name(gatheringEntity.getName())
                .contents(gatheringEntity.getContents())
                .ownerId(gatheringEntity.getGatheringOwnerEntity().getUserEntity().getUserId())
                .ownerName(gatheringEntity.getGatheringOwnerEntity().getUserEntity().getName())
                .sDate(gatheringEntity.getGatheringTimeEntity().getSDate())
                .eDate(gatheringEntity.getGatheringTimeEntity().getEDate())
                .build();
    }
}
