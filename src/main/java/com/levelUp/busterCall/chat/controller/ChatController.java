package com.levelUp.busterCall.chat.controller;

import com.levelUp.busterCall.chat.data.dto.ChatRequestDto;
import com.levelUp.busterCall.chat.data.dto.ChatRoomRequestDto;
import com.levelUp.busterCall.chat.data.dto.ChatRoomResponseDto;
import com.levelUp.busterCall.chat.service.ChatRoomService;
import com.levelUp.busterCall.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatRoomService chatRoomService;

    @MessageMapping("/{roomId}")    //setApplicationDestinationPrefixes 작성한 /app 생략
    @SendTo("/topic/{roomId}")      //enableSimpleBroker 작성한 /topic 생략 물가
    public String sendMessage(ChatRequestDto chatRequestDto, @DestinationVariable Long roomId) {
        return chatRequestDto.getContent();
    }

    @PostMapping("/room")
    public ResponseEntity<ApiResponse<ChatRoomResponseDto>> saveChatRoom(@RequestBody ChatRoomRequestDto chatRoomRequestDto) {
        ChatRoomResponseDto returnValue = chatRoomService.saveChatRoom(chatRoomRequestDto);

        if(returnValue != null) {
            return ResponseEntity.ok(ApiResponse.success(returnValue));
        } else {
            return ResponseEntity.ok(ApiResponse.error());
        }
    }
}
