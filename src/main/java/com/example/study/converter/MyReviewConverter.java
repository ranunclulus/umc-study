package com.example.study.converter;

import com.example.study.domain.Review;
import com.example.study.web.dto.MyReviewResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MyReviewConverter {

    public static MyReviewResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return MyReviewResponseDTO.ReviewPreViewDTO.builder()
                .score(review.getGrade())
                .createdAt(review.getCreatedAt().toLocalDate())
                .restaurantName(review.getRestaurant().getTitle())
                .content(review.getContent())
                .build();
    }
    public static MyReviewResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<MyReviewResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(MyReviewConverter::reviewPreViewDTO).collect(Collectors.toList());

        return MyReviewResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
