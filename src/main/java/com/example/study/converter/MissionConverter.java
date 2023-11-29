package com.example.study.converter;

import com.example.study.apiPayload.code.status.ErrorStatus;
import com.example.study.apiPayload.exception.handler.MissionHandler;
import com.example.study.domain.Mission;
import com.example.study.domain.Restaurant;
import com.example.study.domain.constant.MissionStatus;
import com.example.study.web.dto.MissionRequestDTO;
import com.example.study.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MissionConverter {
    public static MissionResponseDTO.JoinResultDTO toJoinResultDTO(Mission mission) {
        return MissionResponseDTO.JoinResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }


    public static Mission toMission(MissionRequestDTO.JoinDTO request, Restaurant restaurant) {
        MissionStatus missionStatus = null;

        switch (request.getMissionStatus()) {
            case "READY":
                missionStatus = MissionStatus.READY;
                break;
            case "PROCEEDING":
                missionStatus = MissionStatus.PROCEEDING;
                break;
            case "FINISH":
                missionStatus = MissionStatus.FINISH;
                break;
            default:
                throw new MissionHandler(ErrorStatus.MISSION_STATUS_NOT_FOUND);
        }
        return Mission.builder()
                .closedAt(request.getClosedAt())
                .missionStatus(missionStatus)
                .reward(request.getReward())
                .memberMissionList(new ArrayList<>())
                .restaurant(restaurant)
                .build();
    }
}
