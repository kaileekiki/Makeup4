package com.makeup.dto;

import com.makeup.controller.Form.MenteeReservationForm;
import com.makeup.domain.MentoReservation;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenteeReservationDto {
    private Long menteeReservationId;

    private Long memberId;
    private Long mentoReservationId;

    public static MenteeReservationDto menteeFrom(MenteeReservationForm menteeReservationForm) {
        return MenteeReservationDto.builder()
                .memberId(menteeReservationForm.getMemberId())
                .mentoReservationId(menteeReservationForm.getMentoReservationId())
                .build();
    }
}
