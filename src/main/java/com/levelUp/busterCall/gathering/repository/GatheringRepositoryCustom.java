package com.levelUp.busterCall.gathering.repository;

import com.levelUp.busterCall.gathering.data.entity.GatheringEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GatheringRepositoryCustom {

    Page<GatheringEntity> findGatheringByUsing(Pageable pageable);
}
