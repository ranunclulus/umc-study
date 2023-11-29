package com.example.study.web.controller;

import com.example.study.apiPayload.ApiResponse;
import com.example.study.converter.MissionConverter;
import com.example.study.domain.Mission;
import com.example.study.service.MissionService.MissionCommandService;
import com.example.study.web.dto.MissionRequestDTO;
import com.example.study.web.dto.MissionResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
@Slf4j
public class MissionRestController {
    private final MissionCommandService missionCommandService;
    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.JoinResultDTO> join(
            @RequestBody @Valid MissionRequestDTO.JoinDTO request) {
        Mission newMission = missionCommandService.JoinMission(request);
        return ApiResponse.onSuccess(MissionConverter.toJoinResultDTO(newMission));
    }
}
