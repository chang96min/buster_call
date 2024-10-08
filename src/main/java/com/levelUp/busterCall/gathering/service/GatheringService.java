package com.levelUp.busterCall.gathering.service;

import com.levelUp.busterCall.gathering.data.dto.GatheringDto;
import jakarta.servlet.http.HttpServletRequest;

public interface GatheringService {

    public GatheringDto regGathering(GatheringDto gatheringDto);
}
