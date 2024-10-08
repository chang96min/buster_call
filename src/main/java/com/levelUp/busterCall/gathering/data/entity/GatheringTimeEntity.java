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
@Table(name = "gathering_time")
public class GatheringTimeEntity {

    @Id
    @Column(name = "gathering_id")
    private Long gatheringId;

    @Column(name = "s_date")
    private Date sDate;

    @Column(name = "e_date")
    private Date eDate;
}
