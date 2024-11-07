package com.levelUp.busterCall.chat.data.entity;

import com.levelUp.busterCall.gathering.data.entity.GatheringEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "chat_room")
public class ChatRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatRoomId;

    @OneToOne
    @JoinColumn(name = "gathering_id")
    private GatheringEntity gatheringEntity;

    @OneToMany(mappedBy = "chatRoomEntity", cascade = CascadeType.ALL)
    private List<ChatMessageEntity> chatMessageList;
}
