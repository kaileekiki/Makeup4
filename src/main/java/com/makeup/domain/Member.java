package com.makeup.domain;
import com.makeup.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

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

    private String email;
    private String username;
    private String userNickname;
    private String password;
    private String birthYear;
    private Boolean gender;
    private String phoneNumber;


    private int age;




    public static Member toMember(MemberDto memberDto) {
        return Member.builder()
                .email(memberDto.getEmail())
                .username(memberDto.getUsername())
                .userNickname(memberDto.getUserNickname())
                .password(memberDto.getPassword())
                .birthYear(memberDto.getBirthYear())
                .gender(memberDto.getGender())
                .phoneNumber(memberDto.getPhoneNumber())
                .age(findAge(memberDto.getBirthYear()))
                .build();
    }


    public static int findAge (String birthYear){

        LocalDate today = LocalDate.now();
        int todayYear = today.getYear();
        int todayMonth = today.getMonthValue();
        int todayDay = today.getDayOfMonth();

        int year = Integer.parseInt(birthYear.substring(0, 4)); // 생년월일에서 년도 추출
        int month = Integer.parseInt(birthYear.substring(4, 6)); // 생년월일에서 월 추출
        int day = Integer.parseInt(birthYear.substring(6, 8)); // 생년월일에서 일 추출

        int americanAge = todayYear - year;

        // 생일이 안지났으면 - 1
        if(month > todayMonth) {
            americanAge--;
        } else if(month == todayMonth) {
            if(day > todayDay) {
                americanAge--;
            }
        }


        return americanAge;
    }

}

