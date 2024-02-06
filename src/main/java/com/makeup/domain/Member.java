package com.makeup.domain;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter // 이 어노테이션 추가
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Member extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String username;
    private String password;
    private String email;
    private String nickname;
    private String gender;
    private int age;
    private int numOfMatching;
    private int numOfFollower;

}



    // 아직 수정이 필요함!
/*
    public static Member toMember(MemberDto memberDto, College college) {
        return Member.builder()
                .username(memberDto.getUsername())
                .password(memberDto.getPassword())
                .email(memberDto.getEmail())
                .nickname(memberDto.getNickname())
                .college(college)
                .build();
    }
}

 */