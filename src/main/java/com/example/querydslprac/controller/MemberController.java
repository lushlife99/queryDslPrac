package com.example.querydslprac.controller;

import com.example.querydslprac.dto.MemberSearchCondition;
import com.example.querydslprac.dto.MemberTeamDto;
import com.example.querydslprac.repository.MemberJpaRepository;
import com.example.querydslprac.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberJpaRepository memberJpaRepository;
    private final MemberRepository memberRepository;

    @GetMapping("/v1/members")
    public List<MemberTeamDto> searchMemberV1(MemberSearchCondition cond) {
        return memberJpaRepository.search(cond);
    }

    @GetMapping("/v2/members")
    public Page<MemberTeamDto> searchMemberV2(MemberSearchCondition cond, Pageable pageable) {
        return memberRepository.searchPageSimple(cond, pageable);
    }

    @GetMapping("/v3/members")
    public Page<MemberTeamDto> searchMemberV3(MemberSearchCondition cond, Pageable pageable) {
        return memberRepository.searchPageComplex(cond, pageable);
    }
}
