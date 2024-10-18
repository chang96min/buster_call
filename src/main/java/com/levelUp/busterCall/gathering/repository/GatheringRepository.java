package com.levelUp.busterCall.gathering.repository;

import com.levelUp.busterCall.gathering.data.entity.GatheringEntity;
import jakarta.persistence.Entity;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface GatheringRepository extends JpaRepository<GatheringEntity, Long>, GatheringRepositoryCustom {

    GatheringEntity save(GatheringEntity gatheringEntity);

    @EntityGraph(attributePaths = {"gatheringOwnerEntity","gatheringTimeEntity"}, type = EntityGraph.EntityGraphType.FETCH)
    List<GatheringEntity> findAll();
}
