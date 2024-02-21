package com.makeup.controller;

import com.makeup.controller.Response.ApiResponse;
import com.makeup.controller.Response.ExceptionResponse;
import com.makeup.exception.EmailAlreadyExistsException;
import com.makeup.exception.MemberNotFoundException;
import com.makeup.exception.ReservationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController{

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ApiResponse> handleUserEmailAlreadyExistsException(
            EmailAlreadyExistsException e) {
        ApiResponse response =
                ExceptionResponse.builder()
                        .isSuccessful(false)
                        .error(HttpStatus.CONFLICT.getReasonPhrase())
                        .message(e.getMessage())
                        .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<ApiResponse> handleMemberNotFoundException(MemberNotFoundException e) {
        ApiResponse response =
                ExceptionResponse.builder()
                        .isSuccessful(false)
                        .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                        .message(e.getMessage())
                        .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ReservationNotFoundException.class)
    public ResponseEntity<ApiResponse> handleReservationNotFoundException(ReservationNotFoundException e) {
        ApiResponse response =
                ExceptionResponse.builder()
                        .isSuccessful(false)
                        .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                        .message(e.getMessage())
                        .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}