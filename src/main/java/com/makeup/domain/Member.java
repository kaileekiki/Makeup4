package com.makeup.domain;
import com.makeup.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    private String birthYear;
    private boolean gender;

    private int age;
    private int numOfFolling;
    private int numOfFollower;

    public static Member toMember(MemberDto memberDto) {
        return Member.builder()
                .username(memberDto.getUsername())
                .password(memberDto.getPassword())
                .birthYear(memberDto.getBirthYear())
                .gender(memberDto.getGender())
                .age(findAge(memberDto.getBirthYear()))
                .build();
    }

    public static int findAge(String birthYear){
        LocalDate today = LocalDate.now();
        int todayYear = today.getYear();
        int todayMonth = today.getMonthValue();
        int todayDay = today.getDayOfMonth();

        int year = Integer.parseInt(birthYear.substring(0,3));
        int month = Integer.parseInt(birthYear.substring(4,5));
        int day = Integer.parseInt(birthYear.substring(6,7));

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






