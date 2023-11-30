package com.example.study.converter;

import com.example.study.apiPayload.code.status.ErrorStatus;
import com.example.study.apiPayload.exception.handler.MissionHandler;
import com.example.study.domain.Member;
import com.example.study.domain.MemberMission;
import com.example.study.domain.Mission;
import com.example.study.domain.Restaurant;
import com.example.study.domain.constant.MemberMissionStatus;
import com.example.study.domain.constant.MissionStatus;
import com.example.study.web.dto.MemberMissionRequestDTO;
import com.example.study.web.dto.MemberMissionResponseDTO;
import com.example.study.web.dto.MissionRequestDTO;
import com.example.study.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberMissionConverter {
    public static MemberMissionResponseDTO.JoinResultDTO toJoinResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.JoinResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }


    public static MemberMission toMemberMission(MemberMissionRequestDTO.JoinDTO request, Member member, Mission mission) {

        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .memberMissionStatus(MemberMissionStatus.PROCEEDING)
                .build();
    }
}
