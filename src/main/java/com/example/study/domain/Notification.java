package com.example.study.domain;

import com.example.study.domain.common.BaseEntity;
import com.example.study.domain.constant.NofiticationType;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Notification extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String content;

    @Enumerated(EnumType.STRING)
    private NofiticationType nofiticationType;

    @OneToMany(mappedBy = "notification", cascade = CascadeType.ALL)
    private List<MemberNotification> memberNotificationList = new ArrayList<>();
}
