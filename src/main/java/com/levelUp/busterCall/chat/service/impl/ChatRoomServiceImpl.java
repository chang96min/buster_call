package com.levelUp.busterCall.chat.service.impl;

import com.levelUp.busterCall.chat.data.dto.ChatRoomRequestDto;
import com.levelUp.busterCall.chat.data.dto.ChatRoomResponseDto;
import com.levelUp.busterCall.chat.data.entity.ChatRoomEntity;
import com.levelUp.busterCall.chat.repository.ChatRoomRepository;
import com.levelUp.busterCall.chat.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatRoomServiceImpl implements ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    @Override
    public ChatRoomResponseDto saveChatRoom(ChatRoomRequestDto chatRoomRequestDto) {
        try {
            ChatRoomEntity chatRoomEntity = chatRoomRequestDto.toEntity();

            ChatRoomEntity returnChatRoomEntity = chatRoomRepository.save(chatRoomEntity);

            return ChatRoomResponseDto.builder().build().toDto(returnChatRoomEntity);
        } catch (Exception e) {
            return null;
        }
    }
}
