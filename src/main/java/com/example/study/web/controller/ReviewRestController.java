package com.example.study.web.controller;

import com.example.study.apiPayload.ApiResponse;
import com.example.study.converter.MyReviewConverter;
import com.example.study.converter.ReviewConverter;
import com.example.study.domain.Review;
import com.example.study.service.ReviewService.ReviewCommandService;
import com.example.study.service.ReviewService.ReviewQueryService;
import com.example.study.validation.annotation.ExistMember;
import com.example.study.web.dto.MyReviewResponseDTO;
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


    @GetMapping("/{memberId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @Parameters({
            @Parameter(name = "memㅠerId", description = "사용자의 아이디, path variable 입니다!")
    })
    public ApiResponse<MyReviewResponseDTO.ReviewPreViewListDTO> getReviewList(
            @ExistMember @PathVariable(name = "memberId") Long memberId,
            @RequestParam(name = "page") Integer page){
        Page<Review> reviews = reviewQueryService.getReviewList(memberId, page);
        return ApiResponse.onSuccess(MyReviewConverter.reviewPreViewListDTO(reviews));
    }
}
