package com.example.study.repository;

import com.example.study.domain.Member;
import com.example.study.domain.Restaurant;
import com.example.study.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByMember(Member member, PageRequest pageRequest);
    Page<Review> findAllByRestaurant(Restaurant restaurant, PageRequest pageRequest);
}
