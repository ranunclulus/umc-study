package com.example.study.service.MissionService;

import com.example.study.domain.MemberMission;
import com.example.study.domain.Mission;
import com.example.study.domain.Review;
import org.springframework.data.domain.Page;

public interface MissionQueryService {

    Page<MemberMission> getMissionList(Long memberId, Integer page);
}
