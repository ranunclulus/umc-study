package com.example.study.web.controller;

import com.example.study.apiPayload.ApiResponse;
import com.example.study.converter.RestaurantConverter;
import com.example.study.domain.Restaurant;
import com.example.study.service.RestaurantService.RestaurantCommandService;
import com.example.study.web.dto.RestaurantRequestDTO;
import com.example.study.web.dto.RestaurantResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
@Slf4j
public class RestaurantRestController {
    private final RestaurantCommandService restaurantCommandService;

    @PostMapping("/")
    public ApiResponse<RestaurantResponseDTO.JoinResultDTO> join(
            @RequestBody @Valid RestaurantRequestDTO.JoinDTO request) {
        Restaurant newRestaurant = restaurantCommandService.JoinRestaurant(request);
        return ApiResponse.onSuccess(RestaurantConverter.toJoinResultDTO(newRestaurant));
    }
}
