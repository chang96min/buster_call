package com.levelUp.busterCall.chat.data.entity;

import com.levelUp.busterCall.user.data.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chat_message")
public class ChatMessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatMessageId;

    private String message;

    private LocalDateTime regDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity sender;

    @ManyToOne
    @JoinColumn(name = "chat_room_id")
    private ChatRoomEntity chatRoomEntity;
}
