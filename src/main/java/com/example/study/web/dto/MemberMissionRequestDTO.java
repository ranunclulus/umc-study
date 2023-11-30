package com.example.study.web.dto;

import com.example.study.domain.Member;
import com.example.study.domain.Mission;
import com.example.study.domain.constant.MemberMissionStatus;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

public class MemberMissionRequestDTO {
    @Getter
    public static class JoinDTO {
        String member;
        Long missionId;
    }
}
