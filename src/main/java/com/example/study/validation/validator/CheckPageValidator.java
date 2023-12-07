package com.example.study.validation.validator;

import com.example.study.domain.Member;
import com.example.study.repository.MemberRepository;
import com.example.study.validation.annotation.CheckPage;
import com.example.study.validation.annotation.ExistMember;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CheckPageValidator implements ConstraintValidator<CheckPage, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return (value >= 0);
    }
}
