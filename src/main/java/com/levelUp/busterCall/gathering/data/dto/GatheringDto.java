package com.levelUp.busterCall.gathering.data.dto;

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

    private Long views = 0L;
}
