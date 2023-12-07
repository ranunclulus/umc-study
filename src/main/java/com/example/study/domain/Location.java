package com.example.study.domain;

import com.example.study.domain.common.BaseEntity;
import com.example.study.domain.constant.RestaurantType;
import com.example.study.domain.mapping.MemberPrefer;
import com.example.study.domain.mapping.RestaurantLocation;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Location extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String locationName;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<RestaurantLocation> restaurantLocationList = new ArrayList<>();

}
