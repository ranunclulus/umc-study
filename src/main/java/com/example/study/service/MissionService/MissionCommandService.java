package com.example.study.service.MissionService;

import com.example.study.domain.Mission;
import com.example.study.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    Mission JoinMission(MissionRequestDTO.JoinDTO request);
}
