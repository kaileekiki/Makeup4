package com.makeup.dto;

import com.makeup.domain.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private Long memberId;
    private String username;
    private String email;
    private String nickname;
    private String gender;
    private int age;
    private int numOfMatching;
    private int numOfFollower;

    // 모든 필드를 인자로 받는 생성자
    public MemberDto(Long memberId, String username, String email, String nickname, String gender, int age, int numOfMatching, int numOfFollower) {
        this.memberId = memberId;
        this.username = username;
        this.email = email;
        this.nickname = nickname;
        this.gender = gender;
        this.age = age;
        this.numOfMatching = numOfMatching;
        this.numOfFollower = numOfFollower;
    }

    // Member 엔티티를 DTO로 변환하는 메소드
    public static MemberDto from(Member member) {
        return new MemberDto(
                member.getMemberId(),
                member.getUsername(),
                member.getEmail(),
                member.getNickname(),
                member.getGender(),
                member.getAge(),
                member.getNumOfMatching(),
                member.getNumOfFollower());
    }
}
