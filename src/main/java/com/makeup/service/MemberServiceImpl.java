package com.makeup.service;

import com.makeup.domain.Member;
import com.makeup.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Member update(Long id, Member memberDetails) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id " + id));

        member.setUsername(memberDetails.getUsername());
        member.setPassword(memberDetails.getPassword());
        member.setEmail(memberDetails.getEmail());
        member.setNickname(memberDetails.getNickname());
        member.setGender(memberDetails.getGender());
        member.setAge(memberDetails.getAge());
        member.setNumOfFollower(memberDetails.getNumOfFollower());
        member.setNumOfMatching(memberDetails.getNumOfFollower());


        return memberRepository.save(member);
    }

    @Override
    public void delete(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id " + id));
        memberRepository.delete(member);
    }
}