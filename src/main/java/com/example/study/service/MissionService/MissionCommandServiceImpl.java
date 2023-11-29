package com.example.study.service.MissionService;

import com.example.study.converter.MissionConverter;
import com.example.study.domain.Mission;
import com.example.study.domain.Restaurant;
import com.example.study.repository.MissionRepository;
import com.example.study.repository.RestaurantRepository;
import com.example.study.web.dto.MissionRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {
    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;
    @Override
    public Mission JoinMission(MissionRequestDTO.JoinDTO request) {
        Restaurant restaurant = restaurantRepository.findByTitle(request.getRestaurantName());
        Mission newMission = MissionConverter.toMission(request, restaurant);
        restaurant.getMissionList().add(newMission);
        return missionRepository.save(newMission);
    }
}
