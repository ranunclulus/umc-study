package com.example.study.converter;

import com.example.study.domain.Member;
import com.example.study.domain.Restaurant;
import com.example.study.domain.Review;
import com.example.study.web.dto.ReviewRequestDTO;
import com.example.study.web.dto.ReviewResponseDTO;
import java.time.LocalDateTime;

public class ReviewConverter {
    public static ReviewResponseDTO.JoinResultDTO toJoinResultDTO(Review review) {
        return ReviewResponseDTO.JoinResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }


    public static Review toReview(ReviewRequestDTO.JoinDTO request, Restaurant restaurant, Member member) {

        return Review.builder()
                .restaurant(restaurant)
                .member(member)
                .content(request.getContent())
                .grade(request.getGrade())
                .build();
    }
}
