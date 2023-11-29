package com.example.study.web.dto;

import com.example.study.domain.constant.RestaurantType;
import com.example.study.domain.mapping.RestaurantLocation;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantRequestDTO {

    @Getter
    public static class JoinDTO {
        String title;
        Double grade;
        String location;
        LocalDateTime openTime;
        LocalDateTime closeTime;
        LocalDateTime createdAt;
        LocalDateTime updatedAt;
        String restaurantType;
    }
}
