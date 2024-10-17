package com.levelUp.busterCall.gathering.service;

import com.levelUp.busterCall.gathering.data.dto.GatheringDto;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface GatheringService {

    GatheringDto regGathering(GatheringDto gatheringDto);

    List<GatheringDto> getGatheringList(GatheringDto gatheringDto);

    List<GatheringDto> getUsingGatheringList();
}
