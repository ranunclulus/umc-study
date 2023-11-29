package com.example.study.web.dto;

import com.example.study.domain.MemberMission;
import com.example.study.domain.Restaurant;
import com.example.study.domain.constant.MissionStatus;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MissionRequestDTO {
    @Getter
    public static class JoinDTO {
        LocalDateTime closedAt;
        String missionStatus;
        Integer reward;
        String restaurantName;
    }
}
