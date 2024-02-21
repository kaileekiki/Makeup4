package com.makeup.controller.Form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class MenteeReservationForm {

    private Long memberId;
    private Long mentoReservationId;
    //이용해서 멘토 멘티 아이디, 시간 저장
    //기존에 있던 멘토 시간은 지움
}
