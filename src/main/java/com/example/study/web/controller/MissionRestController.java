package com.example.study.web.controller;

import com.example.study.apiPayload.ApiResponse;
import com.example.study.converter.MissionConverter;
import com.example.study.converter.MyMissionConverter;
import com.example.study.converter.RestaurantReviewConverter;
import com.example.study.domain.MemberMission;
import com.example.study.domain.Mission;
import com.example.study.domain.Review;
import com.example.study.service.MissionService.MissionCommandService;
import com.example.study.service.MissionService.MissionQueryService;
import com.example.study.service.MissionService.MissionQueryServiceImpl;
import com.example.study.validation.annotation.CheckPage;
import com.example.study.validation.annotation.ExistMember;
import com.example.study.validation.annotation.ExistRestaurants;
import com.example.study.web.dto.MissionRequestDTO;
import com.example.study.web.dto.MissionResponseDTO;
import com.example.study.web.dto.MyMissionResponseDTO;
import com.example.study.web.dto.RestaurantReviewResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
@Slf4j
public class MissionRestController {
    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;
    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.JoinResultDTO> join(
            @RequestBody @Valid MissionRequestDTO.JoinDTO request) {
        Mission newMission = missionCommandService.JoinMission(request);
        return ApiResponse.onSuccess(MissionConverter.toJoinResultDTO(newMission));
    }

    @GetMapping("{memberId}")
    public ApiResponse<MyMissionResponseDTO.MissionPreViewListDTO> getMyMissionList(
            @ExistMember @PathVariable(name = "memberId") Long memberId,
            @CheckPage  @RequestParam(name = "page") Integer page){
        Page<MemberMission> memberMissions = missionQueryService.getMissionList(memberId, page - 1);
        return ApiResponse.onSuccess(MyMissionConverter.reviewPreViewListDTO(memberMissions));
    }
}
