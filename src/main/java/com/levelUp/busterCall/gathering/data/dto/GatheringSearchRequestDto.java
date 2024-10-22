package com.levelUp.busterCall.gathering.data.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GatheringSearchRequestDto {
    private Long gatheringId;
    private boolean useYn;
    private int page;
    private int size;
}
