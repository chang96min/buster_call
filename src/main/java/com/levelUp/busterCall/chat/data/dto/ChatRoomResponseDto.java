package com.levelUp.busterCall.chat.data.dto;

import com.levelUp.busterCall.chat.data.entity.ChatRoomEntity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoomResponseDto {
    private Long chatRoomId;
    private Long gatheringId;

    public ChatRoomResponseDto toDto(ChatRoomEntity chatRoomEntity) {
        return ChatRoomResponseDto.builder()
                .chatRoomId(chatRoomEntity.getChatRoomId())
                .gatheringId(chatRoomEntity.getGatheringEntity().getGatheringId())
                .build();
    }
}
