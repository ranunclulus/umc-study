package com.example.study.web.dto;

import com.example.study.domain.Member;
import com.example.study.domain.Restaurant;
import com.example.study.validation.annotation.ExistMember;
import com.example.study.validation.annotation.ExistRestaurants;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

public class ReviewRequestDTO {
    @Getter
    public static class JoinDTO {
        String content;
        Double grade;
        @ExistRestaurants
        String restaurant;
        @ExistMember
        String member;
    }
}
