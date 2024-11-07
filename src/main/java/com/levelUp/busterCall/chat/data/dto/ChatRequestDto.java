package com.levelUp.busterCall.chat.data.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatRequestDto {
    private Long senderId;

    private String senderName;

    private String content;
}
