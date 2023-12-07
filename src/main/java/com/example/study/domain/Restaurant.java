package com.example.study.domain;

import com.example.study.domain.common.BaseEntity;
import com.example.study.domain.constant.RestaurantType;
import com.example.study.domain.mapping.MemberPrefer;
import com.example.study.domain.mapping.RestaurantLocation;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Restaurant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String title;

    @Column(nullable = false)
    private Double grade;

    @Column(nullable = false, length = 60)
    private String location;

    private LocalDateTime openTime;

    private LocalDateTime closeTime;

    @Enumerated(EnumType.STRING)
    private RestaurantType restaurantType;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<RestaurantLocation> restaurantLocationList = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

}
