package com.levelUp.busterCall.gathering.repository.impl;

import com.levelUp.busterCall.gathering.data.entity.GatheringEntity;
import com.levelUp.busterCall.gathering.data.entity.QGatheringEntity;
import com.levelUp.busterCall.gathering.data.entity.QGatheringOwnerEntity;
import com.levelUp.busterCall.gathering.data.entity.QGatheringTimeEntity;
import com.levelUp.busterCall.gathering.repository.GatheringRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class GatheringRepositoryCustomImpl implements GatheringRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<GatheringEntity> findGatheringByUsing(Pageable pageable){
        QGatheringEntity qGatheringEntity = QGatheringEntity.gatheringEntity;
        QGatheringOwnerEntity  qGatheringOwnerEntity = QGatheringOwnerEntity.gatheringOwnerEntity;
        QGatheringTimeEntity qGatheringTimeEntity = QGatheringTimeEntity.gatheringTimeEntity;

        LocalDateTime now = LocalDateTime.now();

        List<GatheringEntity> gatheringEntityList = jpaQueryFactory
                .selectFrom(qGatheringEntity)
                .leftJoin(qGatheringEntity.gatheringOwnerEntity, qGatheringOwnerEntity).fetchJoin()
                .leftJoin(qGatheringEntity.gatheringTimeEntity, qGatheringTimeEntity).fetchJoin()
                .where(qGatheringEntity.gatheringTimeEntity.sDate.before(now)
                        .and(qGatheringEntity.gatheringTimeEntity.eDate.after(now))
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return new PageImpl<>(gatheringEntityList);
    }
}
