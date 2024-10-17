package com.levelUp.busterCall.gathering.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "gathering_time")
public class GatheringTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gathering_time_id")
    private Long gatheringTimeId;

    @Column(name = "s_date")
    private LocalDateTime sDate;

    @Column(name = "e_date")
    private LocalDateTime eDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gathering_id")
    private GatheringEntity gatheringEntity;
}
