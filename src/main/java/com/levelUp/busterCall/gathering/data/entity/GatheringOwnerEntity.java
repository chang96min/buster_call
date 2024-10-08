package com.levelUp.busterCall.gathering.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "gathering_owner")
public class GatheringOwnerEntity {

    @Id
    @Column(name = "gathering_id")
    private Long gatheringId;

    @Column(name = "user_id")
    private Long userId;
}
