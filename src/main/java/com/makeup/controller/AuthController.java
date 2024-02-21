package com.makeup.controller;

import com.makeup.controller.Form.SignInForm;
import com.makeup.controller.Form.SignUpForm;
import com.makeup.controller.Response.ApiResponse;
import com.makeup.controller.Response.MemberIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.makeup.service.MemberService;
import com.makeup.dto.MemberDto;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {
    private final MemberService memberService;

    @PostMapping("/sign-up")
    public ResponseEntity<ApiResponse> signUp(@RequestBody SignUpForm form) {
        Long memberId = memberService.addMember(MemberDto.from(form));
        ApiResponse response = new MemberIdResponse(memberId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/sign-up/validation")
    public ResponseEntity<ApiResponse> validateId(@RequestParam String email) {
        memberService.validateEmail(email);
        return ResponseEntity.ok(new ApiResponse(true));
    }

    @PostMapping ("/sign-in")
    public ResponseEntity<ApiResponse> signIn(@RequestBody SignInForm form) {
        Long memberId = memberService.signInMember(MemberDto.from(form));
        ApiResponse response = new MemberIdResponse(memberId);
        return ResponseEntity.ok(response);
    }


}
