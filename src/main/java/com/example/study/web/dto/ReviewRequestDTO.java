package com.example.study.web.dto;

import lombok.Getter;

import java.time.LocalDateTime;

public class ReviewRequestDTO {
    @Getter
    public static class JoinDTO {
        LocalDateTime closedAt;
        String missionStatus;
        Integer reward;
        String restaurantName;
    }
}
