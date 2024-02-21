package com.makeup.controller.Response;

import com.makeup.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class MemberResponse extends ApiResponse{

    private String email;

    private String username;

    private String userNickname;

    private Boolean gender;

    private int age;

    private String phoneNumber;

    public MemberResponse(MemberDto memberDto) {
        this.email = memberDto.getEmail();
        this.username = memberDto.getUsername();
        this.userNickname= memberDto.getUserNickname();
        this.gender = memberDto.getGender();
        this.age = memberDto.getAge();
        this.phoneNumber = memberDto.getPhoneNumber();
    }
}
