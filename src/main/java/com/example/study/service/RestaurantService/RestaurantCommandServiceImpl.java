package com.example.study.service.RestaurantService;

import com.example.study.converter.RestaurantConverter;
import com.example.study.converter.RestaurantLocationConverter;
import com.example.study.domain.Location;
import com.example.study.domain.Restaurant;
import com.example.study.domain.mapping.RestaurantLocation;
import com.example.study.repository.LocationRepository;
import com.example.study.repository.RestaurantLocationRepository;
import com.example.study.repository.RestaurantRepository;
import com.example.study.web.dto.RestaurantRequestDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantCommandServiceImpl implements RestaurantCommandService{
    private final RestaurantRepository restaurantRepository;
    private final LocationRepository locationRepository;
    private final RestaurantLocationRepository restaurantLocationRepository;

    @Override
    @Transactional
    public Restaurant JoinRestaurant(RestaurantRequestDTO.JoinDTO request) {
        Restaurant newRestaurant = RestaurantConverter.toRestaurant(request);
        Location location = locationRepository.findByLocationName(request.getLocation());
        RestaurantLocation restaurantLocation = RestaurantLocationConverter.toRestaurantLocation(newRestaurant, location);
        newRestaurant.getRestaurantLocationList().add(restaurantLocation);
        return restaurantRepository.save(newRestaurant);
    }
}
