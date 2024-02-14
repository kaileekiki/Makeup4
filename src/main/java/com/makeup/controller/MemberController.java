package com.makeup.controller;


import com.makeup.controller.Response.ApiResponse;
import com.makeup.controller.Response.MemberResponse;
import com.makeup.dto.MemberDto;
import com.makeup.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
@CrossOrigin
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/profile/{memberId}")
    public ResponseEntity<ApiResponse> getProfile(@PathVariable Long memberId) {
        MemberDto memberDto = memberService.getProfileOf(memberId);
        ApiResponse response = new MemberResponse(memberDto);
        return ResponseEntity.ok(response);
    }
}
