package com.example.study.service.ReviewService;

import com.example.study.domain.Review;
import com.example.study.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    Review JoinReview(ReviewRequestDTO.JoinDTO request);
}
