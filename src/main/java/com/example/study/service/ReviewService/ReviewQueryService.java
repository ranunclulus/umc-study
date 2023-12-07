package com.example.study.service.ReviewService;

import com.example.study.domain.Member;
import com.example.study.domain.Review;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ReviewQueryService {
    Optional<Member> findMember(Long id);
    Page<Review> getReviewList(Long memberId, Integer page);
}
