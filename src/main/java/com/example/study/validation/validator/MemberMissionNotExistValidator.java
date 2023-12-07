package com.example.study.validation.validator;

import com.example.study.domain.MemberMission;
import com.example.study.repository.MemberMissionRepository;
import com.example.study.validation.annotation.NotExistMemberMession;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class MemberMissionNotExistValidator implements ConstraintValidator<NotExistMemberMession, MemberMission> {
    private final MemberMissionRepository memberMissionRepository;
    @Override
    public boolean isValid(MemberMission value, ConstraintValidatorContext context) {
        return !memberMissionRepository.existsByMemberAndMission(value.getMember(), value.getMission());
    }
}
