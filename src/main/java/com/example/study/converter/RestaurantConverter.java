package com.example.study.converter;

import com.example.study.apiPayload.code.status.ErrorStatus;
import com.example.study.apiPayload.exception.handler.RestaurantHandler;
import com.example.study.domain.Restaurant;
import com.example.study.domain.constant.RestaurantType;
import com.example.study.web.dto.RestaurantRequestDTO;
import com.example.study.web.dto.RestaurantResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class RestaurantConverter {

    public static RestaurantResponseDTO.JoinResultDTO toJoinResultDTO(Restaurant restaurant) {
        return RestaurantResponseDTO.JoinResultDTO.builder()
                .restaurantId(restaurant.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Restaurant toRestaurant(RestaurantRequestDTO.JoinDTO request) {
        RestaurantType restaurantType = null;

        switch (request.getRestaurantType()) {
            case "한식":
                restaurantType = RestaurantType.KOREA;
                break;
            case "디저트":
                restaurantType = RestaurantType.DESERT;
                break;
            default:
                throw new RestaurantHandler(ErrorStatus.RESTAURANT_TYPE_NOT_FOUND);
        }

        return Restaurant.builder()
                .title(request.getTitle())
                .grade(request.getGrade())
                .location(request.getLocation())
                .openTime(request.getOpenTime())
                .closeTime(request.getCloseTime())
                .restaurantType(restaurantType)
                .restaurantLocationList(new ArrayList<>())
                .build();
    }
}
