package com.makeup.service;

import com.makeup.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberService {
    Member save(Member member);
    List<Member> findAll();
    Optional<Member> findById(Long id);
    Member update(Long id, Member memberDetails);
    void delete(Long id);
}