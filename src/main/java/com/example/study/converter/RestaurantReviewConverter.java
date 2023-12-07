package com.example.study.converter;

import com.example.study.domain.Review;
import com.example.study.web.dto.MyReviewResponseDTO;
import com.example.study.web.dto.RestaurantReviewResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class RestaurantReviewConverter {

    public static RestaurantReviewResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return  RestaurantReviewResponseDTO.ReviewPreViewDTO.builder()
                .score(review.getGrade())
                .createdAt(review.getCreatedAt().toLocalDate())
                .writerName(review.getMember().getName())
                .content(review.getContent())
                .build();
    }
    public static RestaurantReviewResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<RestaurantReviewResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(RestaurantReviewConverter::reviewPreViewDTO).collect(Collectors.toList());

        return RestaurantReviewResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
