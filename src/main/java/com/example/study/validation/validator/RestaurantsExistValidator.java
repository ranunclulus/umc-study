package com.example.study.validation.validator;

import com.example.study.domain.Restaurant;
import com.example.study.repository.RestaurantRepository;
import com.example.study.validation.annotation.ExistRestaurants;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RestaurantsExistValidator implements ConstraintValidator<ExistRestaurants, String> {
    private final RestaurantRepository restaurantRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findByTitle(value);
        return optionalRestaurant.isPresent();
    }
}
