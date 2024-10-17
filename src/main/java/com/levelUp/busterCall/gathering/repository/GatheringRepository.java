package com.levelUp.busterCall.gathering.repository;

import com.levelUp.busterCall.gathering.data.entity.GatheringEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDateTime;
import java.util.List;

public interface GatheringRepository extends JpaRepository<GatheringEntity, Long>, JpaSpecificationExecutor<GatheringEntity> {

    public GatheringEntity save(GatheringEntity gatheringEntity);

    @EntityGraph(attributePaths = {"gatheringOwnerEntity","gatheringTimeEntity"}, type = EntityGraph.EntityGraphType.FETCH)
    public List<GatheringEntity> findAll();

    @EntityGraph(attributePaths = {"gatheringOwnerEntity","gatheringTimeEntity"}, type = EntityGraph.EntityGraphType.FETCH)
    public List<GatheringEntity> findByGatheringTimeEntity_sDateBeforeAndGatheringTimeEntity_eDateAfter(LocalDateTime now,LocalDateTime now2);
}
