package com.makeup.controller.Response;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class MentoReservationListResponse {
    private Long mentoReservationId;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime mentoDate;
}
