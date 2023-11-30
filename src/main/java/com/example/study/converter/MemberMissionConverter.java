package com.example.study.converter;

import com.example.study.domain.Member;
import com.example.study.domain.MemberMission;
import com.example.study.domain.Mission;
import com.example.study.domain.constant.MemberMissionStatus;
import com.example.study.web.dto.MemberMissionRequestDTO;
import com.example.study.web.dto.MemberMissionResponseDTO;

import java.time.LocalDateTime;

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
