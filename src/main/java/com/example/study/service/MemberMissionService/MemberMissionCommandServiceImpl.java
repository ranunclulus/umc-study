package com.example.study.service.MemberMissionService;

import com.example.study.apiPayload.code.status.ErrorStatus;
import com.example.study.apiPayload.exception.handler.MemberMissionHandler;
import com.example.study.apiPayload.exception.handler.MissionHandler;
import com.example.study.converter.MemberMissionConverter;
import com.example.study.converter.MissionConverter;
import com.example.study.domain.Member;
import com.example.study.domain.MemberMission;
import com.example.study.domain.Mission;
import com.example.study.domain.Restaurant;
import com.example.study.repository.MemberMissionRepository;
import com.example.study.repository.MemberRepository;
import com.example.study.repository.MissionRepository;
import com.example.study.repository.RestaurantRepository;
import com.example.study.validation.annotation.NotExistMemberMession;
import com.example.study.web.dto.MemberMissionRequestDTO;
import com.example.study.web.dto.MissionRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService{
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public MemberMission JoinMemberMission(MemberMissionRequestDTO.JoinDTO request) {
        Member member = memberRepository.findByName(request.getMember()).get();
        Mission mission = missionRepository.findById(request.getMissionId()).get();
        if (memberMissionRepository.existsByMemberAndMission(member, mission))
            throw new MemberMissionHandler(ErrorStatus.MEMBER_MISSION_ALREADY_EXIST);
        MemberMission memberMission = MemberMissionConverter.toMemberMission(request, member, mission);
        return memberMissionRepository.save(memberMission);
    }
}
