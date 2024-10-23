package com.levelUp.busterCall.gathering.service;

import com.levelUp.busterCall.gathering.data.dto.*;

import java.util.List;

public interface GatheringService {
    GatheringSaveResponseDto saveGathering(GatheringSaveRequestDto gatheringSaveDto);

    List<GatheringSearchResponseDto> getGatheringList(GatheringSearchRequestDto gatheringSearchRequestDto);

    GatheringDetailResponseDto getGatheringDetail(Long gatheringId);
}
