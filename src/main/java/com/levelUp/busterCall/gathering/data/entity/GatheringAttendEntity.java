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
@Table(name = "gathering_attend")
public class GatheringAttendEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gathering_attend_id")
    private Long gatheringAttendId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "reg_date")
    private Date regDate;

    @Column(name = "out_date")
    private Date outDate;

    @ManyToOne
    @JoinColumn(name = "gathering_id")
    private GatheringEntity gatheringEntity;
}
