package com.levelUp.busterCall.gathering.controller;

import com.levelUp.busterCall.gathering.data.dto.GatheringDto;
import com.levelUp.busterCall.gathering.service.GatheringService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/gathering")
public class GatheringController {

    private final GatheringService gatheringService;

    @PostMapping(value = "/regGathering")
    public GatheringDto regGathering(HttpServletRequest request, @RequestBody GatheringDto gatheringDto) {
        GatheringDto returnValue = gatheringService.regGathering(gatheringDto);

        return  returnValue;
    }
}
