package com.makeup.controller.Response;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class ExceptionResponse extends ApiResponse {

    private String error;
    private String message;

    @Builder
    public ExceptionResponse(boolean isSuccessful, String error, String message) {
        super(isSuccessful);
        this.error = error;
        this.message = message;
    }


}
