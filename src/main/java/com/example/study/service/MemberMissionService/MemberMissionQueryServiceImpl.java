package com.example.study.service.MemberMissionService;

import com.example.study.repository.MemberMissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionCommandService{
    private final MemberMissionRepository missionRepository;
}
