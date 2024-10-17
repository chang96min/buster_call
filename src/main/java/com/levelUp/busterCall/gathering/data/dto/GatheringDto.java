package com.levelUp.busterCall.gathering.data.dto;

import com.levelUp.busterCall.gathering.data.entity.GatheringEntity;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GatheringDto {

    private Long gatheringId;

    private String name;

    private String contents;

    private GatheringOwnerDto gatheringOwnerDto;

    private GatheringTimeDto gatheringTimeDto;

    public GatheringEntity toEntity(){
        return GatheringEntity.builder()
                .gatheringId(this.gatheringId)
                .name(this.name)
                .contents(this.contents)
                .build();
    }

    public GatheringDto toDto(GatheringEntity gatheringEntity) {
        return GatheringDto.builder()
                .gatheringId(gatheringEntity.getGatheringId())
                .name(gatheringEntity.getName())
                .contents(gatheringEntity.getContents())
                .build();
    }
}
