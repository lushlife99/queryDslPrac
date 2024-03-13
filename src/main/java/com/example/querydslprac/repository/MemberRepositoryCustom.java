package com.example.querydslprac.repository;

import com.example.querydslprac.dto.MemberSearchCondition;
import com.example.querydslprac.dto.MemberTeamDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberRepositoryCustom {
    List<MemberTeamDto> search(MemberSearchCondition cond);
    Page<MemberTeamDto> searchPageSimple(MemberSearchCondition cond, Pageable pageable);
    Page<MemberTeamDto> searchPageComplex(MemberSearchCondition cond, Pageable pageable);
}
