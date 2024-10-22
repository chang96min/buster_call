package com.levelUp.busterCall.gathering.repository;

import com.levelUp.busterCall.gathering.data.entity.GatheringEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GatheringRepositoryCustom {

    List<GatheringEntity> findGatheringByUsing(Pageable pageable);
}
