package com.example.study.validation.validator;

import com.example.study.domain.Member;
import com.example.study.repository.MemberRepository;
import com.example.study.validation.annotation.ExistMember;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MemberExistValidator implements ConstraintValidator<ExistMember, String> {
    private final MemberRepository memberRepository;
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Optional<Member> optionalMember = memberRepository.findByName(value);
        return optionalMember.isPresent();
    }
}
