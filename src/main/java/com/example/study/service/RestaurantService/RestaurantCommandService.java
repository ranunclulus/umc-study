package com.example.study.service.RestaurantService;

import com.example.study.domain.Restaurant;
import com.example.study.repository.RestaurantRepository;
import com.example.study.web.dto.RestaurantRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


public interface RestaurantCommandService {
    Restaurant JoinRestaurant(RestaurantRequestDTO.JoinDTO request);
}
