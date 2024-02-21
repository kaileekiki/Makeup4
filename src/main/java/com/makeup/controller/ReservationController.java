package com.makeup.controller;

import com.makeup.controller.Form.MenteeReservationForm;
import com.makeup.controller.Form.MentoReservationForm;
import com.makeup.controller.Response.ApiResponse;
import com.makeup.controller.Response.MentoDateIdResponse;
import com.makeup.controller.Response.MentoReservationListResponse;
import com.makeup.dto.MenteeReservationDto;
import com.makeup.dto.ReservationDto;
import com.makeup.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
@CrossOrigin
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping("/mento")
    public ResponseEntity<ApiResponse> mentoReservation(@RequestBody MentoReservationForm form) {
        Long mentoReservationId = reservationService.addReservationDate(form);
        ApiResponse response = new MentoDateIdResponse(mentoReservationId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/view/mento/{memberId}")
    public List<ReservationDto> mentoReservationView(@PathVariable Long memberId){
        List<ReservationDto> mentoReservationList = reservationService.findAll(memberId);
        return mentoReservationList;
    }

    @DeleteMapping("/mento/{mentoReservationId}")
    public ResponseEntity<ApiResponse> deleteMentoReservation(@PathVariable Long mentoReservationId) {
        reservationService.deleteReservation(mentoReservationId);
        ApiResponse response = new MentoDateIdResponse(mentoReservationId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/mentee")
    public ResponseEntity<ApiResponse> menteeReservation(@RequestBody MenteeReservationForm form) {
        Long reservationId = reservationService.menteeReservation(MenteeReservationDto.menteeFrom(form));
        ApiResponse response = new MentoDateIdResponse(reservationId);
        return ResponseEntity.ok(response);
    }

}
