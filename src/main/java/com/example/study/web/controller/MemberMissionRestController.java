package com.example.study.web.controller;

import com.example.study.apiPayload.ApiResponse;
import com.example.study.converter.MemberMissionConverter;
import com.example.study.domain.MemberMission;
import com.example.study.service.MemberMissionService.MemberMissionCommandService;
import com.example.study.web.dto.MemberMissionRequestDTO;
import com.example.study.web.dto.MemberMissionResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/membermissions")
@Slf4j
public class MemberMissionRestController {
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/")
    public ApiResponse<MemberMissionResponseDTO.JoinResultDTO> join(
            @RequestBody @Valid MemberMissionRequestDTO.JoinDTO request) {
        MemberMission newMemberMission = memberMissionCommandService.JoinMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toJoinResultDTO(newMemberMission));
    }
}
