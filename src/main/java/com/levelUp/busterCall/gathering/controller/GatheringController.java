package com.levelUp.busterCall.gathering.controller;

import com.levelUp.busterCall.gathering.data.dto.GatheringDto;
import com.levelUp.busterCall.gathering.service.GatheringService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/gathering")
public class GatheringController {

    private final GatheringService gatheringService;

    @PostMapping(value = "/saveGathering")
    public String saveGathering(HttpServletRequest request, @RequestBody GatheringDto gatheringDto) {
        return gatheringService.saveGathering(gatheringDto);
    }

    @GetMapping(value = "/getGatheringList")
    public List<GatheringDto> getGatheringList(HttpServletRequest request, HttpServletResponse response, @RequestBody GatheringDto gatheringDto) {
        return gatheringService.getGatheringList(gatheringDto);
    }

    @GetMapping(value = "/getUsingGatheringList")
    public List<GatheringDto> getUsingGatheringList(HttpServletRequest request, HttpServletResponse response) {
        return gatheringService.getUsingGatheringList();
    }

    @GetMapping("/getGatheringDetail")
    public GatheringDto getGatheringDetail(HttpServletRequest request, HttpServletResponse response, @RequestBody GatheringDto gatheringDto) {
        return gatheringService.getGatheringDetail(gatheringDto);
    }
}
