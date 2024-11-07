package com.levelUp.busterCall.chat.service;

import com.levelUp.busterCall.chat.data.dto.ChatRoomRequestDto;
import com.levelUp.busterCall.chat.data.dto.ChatRoomResponseDto;

public interface ChatRoomService {
    public ChatRoomResponseDto saveChatRoom(ChatRoomRequestDto chatRoomRequestDto);
}
