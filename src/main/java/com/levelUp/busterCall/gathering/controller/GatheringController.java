package com.levelUp.busterCall.gathering.controller;

import com.levelUp.busterCall.gathering.data.dto.GatheringDto;
import com.levelUp.busterCall.gathering.service.GatheringService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/getGatheringList")
    public List<GatheringDto> getGatheringList(HttpServletRequest request, HttpServletResponse response, @RequestBody GatheringDto gatheringDto) {

        List<GatheringDto> returnValue = gatheringService.getGatheringList(gatheringDto);

        return returnValue;
    }

    @GetMapping(value = "/getUsingGatheringList")
    public List<GatheringDto> getUsingGatheringList(HttpServletRequest request, HttpServletResponse response) {

        List<GatheringDto> returnValue = gatheringService.getUsingGatheringList();

        return returnValue;
    }
}
