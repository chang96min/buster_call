package com.levelUp.busterCall.gathering.data.dto;

import com.levelUp.busterCall.gathering.data.entity.GatheringEntity;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GatheringSaveResponseDto {
    private Long gatheringId;
    private String name;
    private String contents;
    private Long userId;
    private LocalDateTime sDate;
    private LocalDateTime eDate;

    public GatheringSaveResponseDto toDto(GatheringEntity gatheringEntity) {
        return GatheringSaveResponseDto.builder()
                .gatheringId(gatheringEntity.getGatheringId())
                .name(gatheringEntity.getName())
                .contents(gatheringEntity.getContents())
                .userId(gatheringEntity.getGatheringOwnerEntity().getUserId())
                .sDate(gatheringEntity.getGatheringTimeEntity().getSDate())
                .eDate(gatheringEntity.getGatheringTimeEntity().getEDate())
                .build();
    }
}
