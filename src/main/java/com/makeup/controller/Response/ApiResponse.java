package com.makeup.controller.Response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class ApiResponse {
    private Boolean isSuccessful = true;

    public ApiResponse(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }
}
