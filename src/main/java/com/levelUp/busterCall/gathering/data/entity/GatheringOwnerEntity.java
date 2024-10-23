package com.levelUp.busterCall.gathering.data.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gathering_owner_id")
    private Long gatheringOwnerId;

    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @JoinColumn(name = "gathering_id")
    private GatheringEntity gatheringEntity;
}
