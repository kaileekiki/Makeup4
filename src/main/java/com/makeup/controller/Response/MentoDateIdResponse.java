package com.makeup.controller.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@AllArgsConstructor
public class MentoDateIdResponse extends ApiResponse {
    private Long mentoReservationId;

}
