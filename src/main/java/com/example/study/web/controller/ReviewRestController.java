package com.example.study.web.controller;

import com.example.study.apiPayload.ApiResponse;
import com.example.study.converter.ReviewConverter;
import com.example.study.domain.Review;
import com.example.study.service.ReviewService.ReviewCommandService;
import com.example.study.web.dto.ReviewRequestDTO;
import com.example.study.web.dto.ReviewResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
@Slf4j
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;
    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.JoinResultDTO> join(@RequestBody @Valid ReviewRequestDTO.JoinDTO request) {
        Review review = reviewCommandService.JoinReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toJoinResultDTO(review));
    }
}
