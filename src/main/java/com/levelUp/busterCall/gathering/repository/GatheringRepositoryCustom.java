package com.levelUp.busterCall.gathering.repository;

import com.levelUp.busterCall.gathering.data.entity.GatheringEntity;

import java.util.List;

public interface GatheringRepositoryCustom {

    List<GatheringEntity> findGatheringByUsing();
}
