package com.example.study.web.controller;

import com.example.study.apiPayload.ApiResponse;
import com.example.study.converter.MyReviewConverter;
import com.example.study.converter.RestaurantReviewConverter;
import com.example.study.converter.ReviewConverter;
import com.example.study.domain.Review;
import com.example.study.service.ReviewService.ReviewCommandService;
import com.example.study.service.ReviewService.ReviewQueryService;
import com.example.study.validation.annotation.CheckPage;
import com.example.study.validation.annotation.ExistMember;
import com.example.study.validation.annotation.ExistRestaurants;
import com.example.study.web.dto.MyReviewResponseDTO;
import com.example.study.web.dto.RestaurantReviewResponseDTO;
import com.example.study.web.dto.ReviewRequestDTO;
import com.example.study.web.dto.ReviewResponseDTO;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
@Slf4j
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;
    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.JoinResultDTO> join(@RequestBody @Valid ReviewRequestDTO.JoinDTO request) {
        Review review = reviewCommandService.JoinReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toJoinResultDTO(review));
    }


    @GetMapping("memver/{memberId}")
    public ApiResponse<MyReviewResponseDTO.ReviewPreViewListDTO> getReviewList(
            @ExistMember @PathVariable(name = "memberId") Long memberId,
            @CheckPage @RequestParam(name = "page") Integer page){
        Page<Review> reviews = reviewQueryService.getReviewList(memberId, page);
        return ApiResponse.onSuccess(MyReviewConverter.reviewPreViewListDTO(reviews));
    }

    @GetMapping("restaurant/{restaurantId}")
    public ApiResponse<RestaurantReviewResponseDTO.ReviewPreViewListDTO> getRestaurantReviewList(
            @ExistRestaurants @PathVariable(name = "restaurantId") Long restaurantId,
            @CheckPage  @RequestParam(name = "page") Integer page){
        Page<Review> reviews = reviewQueryService.getRestaurantReviewList(restaurantId, page);
        return ApiResponse.onSuccess(RestaurantReviewConverter.reviewPreViewListDTO(reviews));
    }
}
