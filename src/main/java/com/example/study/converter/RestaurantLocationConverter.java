package com.example.study.converter;

import com.example.study.domain.Location;
import com.example.study.domain.Restaurant;
import com.example.study.domain.mapping.RestaurantLocation;


public class RestaurantLocationConverter {

    public static RestaurantLocation toRestaurantLocation(Restaurant restaurant, Location location) {
        return RestaurantLocation.builder()
                .restaurant(restaurant)
                .location(location)
                .build();
    }
}
