package com.makeup.service;

import com.makeup.dto.MemberDto;
import com.makeup.exception.EmailAlreadyExistsException;
import com.makeup.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.makeup.domain.Member;
import com.makeup.exception.MemberNotFoundException;

import static com.makeup.domain.Member.findAge;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Long addMember(MemberDto memberDto) {
        Member member = memberRepository.save(Member.toMember(memberDto));
        return member.getMemberId();
    }

    public void validateEmail(String email) {
        memberRepository
                .findByEmail(email)
                .ifPresent(
                        (__) -> {
                            throw new EmailAlreadyExistsException();
                        });
    }

    public Long signInMember(MemberDto memberDto) {
        Member member =
                memberRepository
                        .findMemberByEmailAndPassword(memberDto.getEmail(), memberDto.getPassword())
                        .orElseThrow(MemberNotFoundException::new);
        return member.getMemberId();
    }

    public MemberDto getProfileOf(Long memberId) {
        System.out.println("memberId = " + memberId);
        Member member =
                memberRepository
                        .findMemberById(memberId)
                        .orElseThrow(MemberNotFoundException::new);
        return MemberDto.from(member);
    }

    @Transactional
    public Long editProfileOf(Long memberId, MemberDto memberDto) {
        Member member =
                memberRepository
                        .findMemberById(memberId)
                        .orElseThrow(MemberNotFoundException::new);
        member.setUsername(memberDto.getUsername());
        member.setBirthYear(memberDto.getBirthYear());
        member.setGender(memberDto.getGender());
        member.setAge(findAge(memberDto.getBirthYear()));
        return member.getMemberId();
    }
}
