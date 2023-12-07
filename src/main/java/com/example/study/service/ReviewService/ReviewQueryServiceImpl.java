package com.example.study.service.ReviewService;

import com.example.study.domain.Member;
import com.example.study.domain.Restaurant;
import com.example.study.domain.Review;
import com.example.study.repository.MemberRepository;
import com.example.study.repository.RestaurantRepository;
import com.example.study.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();
        Page<Review> myReview = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
        return myReview;
    }

    @Override
    public Page<Review> getRestaurantReviewList(Long restaurantId, Integer page) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        Page<Review> restaurantReview = reviewRepository.findAllByRestaurant(restaurant, PageRequest.of(page,10));
        return restaurantReview;

    }
}
