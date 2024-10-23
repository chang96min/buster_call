package com.levelUp.busterCall.gathering.data.dto;

import com.levelUp.busterCall.gathering.data.entity.GatheringAttendEntity;
import com.levelUp.busterCall.gathering.data.entity.GatheringEntity;
import com.levelUp.busterCall.gathering.data.entity.GatheringViewsEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class GatheringDetailResponseDto {
    //Gathering
    private Long gatheringId;
    private String name;
    private String contents;
    //GatheringOwner
    private Long gatheringOwnerId;
    private String gatheringOwnerName;
    //GatheringTime
    private LocalDateTime sDate;
    private LocalDateTime eDate;
    //GatheringAttend
    List<GatheringAttendDto> gatheringAttendDtoList;
    //GatheringViews
    List<GatheringViewsDto> gatheringViewsDtoList;

    @Data
    @Builder
    public static class GatheringAttendDto {
        private Long gatheringAttendId;
        private Long userId;
        private String name;

        public GatheringAttendDto toDto(GatheringAttendEntity gatheringAttendEntity) {
            return GatheringAttendDto.builder()
                    .gatheringAttendId(gatheringAttendEntity.getGatheringAttendId())
                    .userId(gatheringAttendEntity.getUserEntity().getUserId())
                    .name(gatheringAttendEntity.getUserEntity().getName())
                    .build();
        }
    }

    @Data
    @Builder
    public static class GatheringViewsDto {
        private Long gatheringViewsId;
        private Long userId;
        private String name;
        private Date  regDate;

        public GatheringViewsDto toDto(GatheringViewsEntity gatheringViewsEntity) {
            return GatheringViewsDto.builder()
                    .gatheringViewsId(gatheringViewsEntity.getGatheringViewId())
                    .userId(gatheringViewsEntity.getUserEntity().getUserId())
                    .name(gatheringViewsEntity.getUserEntity().getName())
                    .build();
        }
    }

    public GatheringDetailResponseDto toDto(GatheringEntity gatheringEntity) {
        return GatheringDetailResponseDto.builder()
                .gatheringId(gatheringEntity.getGatheringId())
                .name(gatheringEntity.getName())
                .contents(gatheringEntity.getContents())
                .gatheringOwnerId(gatheringEntity.getGatheringOwnerEntity().getGatheringOwnerId())
                .gatheringOwnerName(gatheringEntity.getGatheringOwnerEntity().getUserEntity().getName())
                .sDate(gatheringEntity.getGatheringTimeEntity().getSDate())
                .eDate(gatheringEntity.getGatheringTimeEntity().getEDate())
                .gatheringAttendDtoList(gatheringEntity.getGatheringAttendEntityList().stream().map(data -> GatheringAttendDto.builder().build().toDto(data)).collect(Collectors.toList()))
                .gatheringViewsDtoList(gatheringEntity.getGatheringViewsEntityList().stream().map(data -> GatheringViewsDto.builder().build().toDto(data)).collect(Collectors.toList()))
                .build();
    }
}
