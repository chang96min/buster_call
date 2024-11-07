package com.levelUp.busterCall.chat.data.dto;

import com.levelUp.busterCall.chat.data.entity.ChatRoomEntity;
import com.levelUp.busterCall.gathering.data.entity.GatheringEntity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoomRequestDto {

    private Long gatheringId;

    public ChatRoomEntity toEntity() {
        GatheringEntity gatheringEntity = GatheringEntity.builder()
                .gatheringId(this.gatheringId)
                .build();

        return ChatRoomEntity.builder()
                .gatheringEntity(gatheringEntity)
                .build();
    }
}
