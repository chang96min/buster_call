package com.levelUp.busterCall.gathering.repository.impl;

import com.levelUp.busterCall.gathering.data.entity.GatheringEntity;
import com.levelUp.busterCall.gathering.data.entity.QGatheringEntity;
import com.levelUp.busterCall.gathering.repository.GatheringRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class GatheringRepositoryCustomImpl implements GatheringRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<GatheringEntity> findGatheringByUsing(){
        QGatheringEntity qGatheringEntity = QGatheringEntity.gatheringEntity;
        LocalDateTime now = LocalDateTime.now();

        List<GatheringEntity> gatheringEntityList = jpaQueryFactory
                .selectFrom(qGatheringEntity)
                .where(qGatheringEntity.gatheringTimeEntity.sDate.before(now)
                        .and(qGatheringEntity.gatheringTimeEntity.eDate.after(now))
                )
                .fetch();

        return gatheringEntityList;
    }
}
