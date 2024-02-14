package com.makeup.service;

import com.makeup.dto.MemberDto;
import com.makeup.exception.UsernameAlreadyExistsException;
import com.makeup.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.makeup.domain.Member;
import com.makeup.exception.MemberNotFoundException;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Long addMember(MemberDto memberDto) {
        Member member = memberRepository.save(Member.toMember(memberDto));
        return member.getMemberId();
    }

    public void validateUsername(String username) {
        memberRepository
                .findByUsername(username)
                .ifPresent(
                        (__) -> {
                            throw new UsernameAlreadyExistsException();
                        });
    }

    public Long signInMember(MemberDto memberDto) {
        Member member =
                memberRepository
                        .findMemberByUsernameAndPassword(memberDto.getUsername(), memberDto.getPassword())
                        .orElseThrow(MemberNotFoundException::new);
        return member.getMemberId();
    }
}
