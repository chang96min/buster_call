package com.levelUp.busterCall.gathering.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "gathering")
public class GatheringEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gatheringId;

    private String name;

    private String contents;

    @OneToOne(mappedBy = "gatheringEntity",cascade = CascadeType.ALL)
    private GatheringOwnerEntity gatheringOwnerEntity;

    @OneToOne(mappedBy = "gatheringEntity", cascade = CascadeType.ALL)
    private GatheringTimeEntity gatheringTimeEntity;

    @OneToMany(mappedBy = "gatheringEntity", cascade = CascadeType.ALL)
    private List<GatheringAttendEntity> gatheringAttendEntityList;

    @OneToMany(mappedBy = "gatheringEntity", cascade = CascadeType.ALL)
    private List<GatheringViewsEntity> gatheringViewsEntityList;

}
