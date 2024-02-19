package com.makeup.controller;

import com.makeup.controller.Form.MentoReservationForm;
import com.makeup.controller.Form.SignUpForm;
import com.makeup.controller.Response.ApiResponse;
import com.makeup.controller.Response.MemberIdResponse;
import com.makeup.controller.Response.MemberResponse;
import com.makeup.controller.Response.MentoDateIdResponse;
import com.makeup.domain.MentoReservation;
import com.makeup.dto.MemberDto;
import com.makeup.dto.ReservationDto;
import com.makeup.service.MemberService;
import com.makeup.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
@CrossOrigin
public class ResevationController {
    private final ReservationService reservationService;

    @PostMapping("/mento")
    public ResponseEntity<ApiResponse> mentoReservation(@RequestBody MentoReservationForm form) {
        Long mentoReservationId = reservationService.addReservationDate(form);
        ApiResponse response = new MentoDateIdResponse(mentoReservationId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/view/mento/{memberId}")
    public List<ReservationDto> mentoReservationView(@RequestParam Long mentoReservationId){
        List<ReservationDto> mentoReservationList = reservationService.findAll(mentoReservationId);
        return mentoReservationList;
    }

}
