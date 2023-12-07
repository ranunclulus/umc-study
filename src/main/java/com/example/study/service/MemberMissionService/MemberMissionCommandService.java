package com.example.study.service.MemberMissionService;

import com.example.study.domain.MemberMission;
import com.example.study.web.dto.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    MemberMission JoinMemberMission(MemberMissionRequestDTO.JoinDTO request);
}
