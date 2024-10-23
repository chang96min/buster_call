package com.levelUp.busterCall.gathering.data.entity;

import com.levelUp.busterCall.user.data.entity.UserEntity;
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToOne
    @JoinColumn(name = "gathering_id")
    private GatheringEntity gatheringEntity;
}
