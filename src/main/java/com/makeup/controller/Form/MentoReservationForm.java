package com.makeup.controller.Form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class MentoReservationForm {
    private Long memberId;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime mentoDate;

}
