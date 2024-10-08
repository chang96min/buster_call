package com.levelUp.busterCall.gathering.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "gathering_id")
    private Long gatheringId;

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    private int order;

    @Column(name = "reg_date")
    private Date regDate;
}
