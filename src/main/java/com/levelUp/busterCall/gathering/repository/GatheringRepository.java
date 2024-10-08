package com.levelUp.busterCall.gathering.repository;

import com.levelUp.busterCall.gathering.data.dto.GatheringDto;
import com.levelUp.busterCall.gathering.data.entity.GatheringEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GatheringRepository extends JpaRepository<GatheringEntity, Long> {

    //SAVE Gathering Table
    public GatheringEntity save(GatheringEntity gatheringEntity);

}
