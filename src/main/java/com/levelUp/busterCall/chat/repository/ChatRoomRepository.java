package com.levelUp.busterCall.chat.repository;

import com.levelUp.busterCall.chat.data.entity.ChatRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, Long> {

}
