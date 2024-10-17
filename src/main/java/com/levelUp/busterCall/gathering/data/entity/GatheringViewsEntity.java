package com.levelUp.busterCall.gathering.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "gathering_views")
public class GatheringViewsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gathering_view_id")
    private Long gatheringViewId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "reg_date")
    private Date regDate;

    @ManyToOne
    @JoinColumn(name = "gathering_id")
    private GatheringEntity gatheringEntity;
}
