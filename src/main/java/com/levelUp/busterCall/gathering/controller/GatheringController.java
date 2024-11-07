package com.levelUp.busterCall.gathering.controller;

import com.levelUp.busterCall.common.response.ApiResponse;
import com.levelUp.busterCall.gathering.data.dto.*;
import com.levelUp.busterCall.gathering.service.GatheringService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/gathering")
public class GatheringController {

    private final GatheringService gatheringService;

    @PostMapping(value = "/gathering")
    public ResponseEntity<ApiResponse<GatheringSaveResponseDto>> saveGathering(@RequestBody GatheringSaveRequestDto gatheringSaveRequestDto) {
        GatheringSaveResponseDto returnValue = gatheringService.saveGathering(gatheringSaveRequestDto);
        if(returnValue != null){
            return ResponseEntity.ok(ApiResponse.success(returnValue));
        }else{
            return ResponseEntity.ok(ApiResponse.error());
        }
    }

    @GetMapping(value = "/gatherings")
    public ResponseEntity<ApiResponse<List<GatheringSearchResponseDto>>> getGatheringList(@RequestParam int page,
                                                                                          @RequestParam int size,
                                                                                          @RequestParam boolean useYn) {
        GatheringSearchRequestDto gatheringSearchRequestDto = GatheringSearchRequestDto.builder()
                .page(page)
                .size(size)
                .useYn(useYn)
                .build();
        List<GatheringSearchResponseDto> returnValue = gatheringService.getGatheringList(gatheringSearchRequestDto);
        if(returnValue != null) {
            return ResponseEntity.ok(ApiResponse.success(returnValue));
        } else {
            return ResponseEntity.ok(ApiResponse.error());
        }
    }

    @GetMapping("/gathering/{gatheringId}")
    public ResponseEntity<ApiResponse<GatheringDetailResponseDto>> getGatheringDetail(@PathVariable Long gatheringId) {
        GatheringDetailResponseDto returnValue = gatheringService.getGatheringDetail(gatheringId);
        if(returnValue != null) {
            return ResponseEntity.ok(ApiResponse.success(returnValue));
        }else {
            return ResponseEntity.ok(ApiResponse.error());
        }
    }
}
