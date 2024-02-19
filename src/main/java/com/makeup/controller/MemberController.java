package com.makeup.controller;


import com.makeup.controller.Form.EditMemberForm;
import com.makeup.controller.Response.ApiResponse;
import com.makeup.controller.Response.MemberIdResponse;
import com.makeup.controller.Response.MemberResponse;
import com.makeup.domain.Member;
import com.makeup.domain.Post;
import com.makeup.dto.MemberDto;
import com.makeup.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PutMapping("/edit/{memberId}")
    public ResponseEntity<ApiResponse> updateMember(@PathVariable Long memberId, @RequestBody EditMemberForm form) {
        Long editedMemberId = memberService.editProfileOf(memberId, MemberDto.from(form));
        ApiResponse response = new MemberIdResponse(editedMemberId);
        return ResponseEntity.ok(response);
    }



}
