package com.makeup.dto;

import com.makeup.controller.Form.SignUpForm;
import com.makeup.domain.MentoReservation;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    private Long mentoReservationId;

    private LocalDateTime mentoDate;

    public static ReservationDto MentoFrom(MentoReservation mentoReservation) {
        return ReservationDto.builder()
                .mentoDate(mentoReservation.getMentoDate())
                .build();
    }
}