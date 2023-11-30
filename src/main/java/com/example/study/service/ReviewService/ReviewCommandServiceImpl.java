package com.example.study.service.ReviewService;

import com.example.study.converter.ReviewConverter;
import com.example.study.domain.Member;
import com.example.study.domain.Restaurant;
import com.example.study.domain.Review;
import com.example.study.repository.MemberRepository;
import com.example.study.repository.RestaurantRepository;
import com.example.study.repository.ReviewRepository;
import com.example.study.web.dto.ReviewRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public Review JoinReview(ReviewRequestDTO.JoinDTO request) {
        Member member = memberRepository.findByName(request.getMember()).get();
        Restaurant restaurant = restaurantRepository.findByTitle(request.getRestaurant()).get();
        Review newReview = ReviewConverter.toReview(request, restaurant, member);
        return reviewRepository.save(newReview);
    }
}
