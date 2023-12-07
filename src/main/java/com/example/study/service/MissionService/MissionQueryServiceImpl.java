package com.example.study.service.MissionService;

import com.example.study.domain.Member;
import com.example.study.domain.MemberMission;
import com.example.study.domain.Mission;
import com.example.study.repository.MemberMissionRepository;
import com.example.study.repository.MemberRepository;
import com.example.study.repository.MissionRepository;
import com.example.study.validation.annotation.CheckPage;
import com.example.study.validation.annotation.ExistMember;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;

    @Override
    public Page<MemberMission> getMissionList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();
        Page<MemberMission> missions = memberMissionRepository.findAllByMember(member, PageRequest.of(page, 10));
        return missions;
    }
}
