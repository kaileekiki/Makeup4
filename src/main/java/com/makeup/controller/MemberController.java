package com.makeup.controller;

import com.makeup.domain.Member;
import com.makeup.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/")
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        Member savedMember = memberService.save(member);
        return ResponseEntity.ok(savedMember);
    }

    @GetMapping("/")
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.findAll();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
        Member member = memberService.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id " + id));
        return ResponseEntity.ok(member);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member memberDetails) {
        Member updatedMember = memberService.update(id, memberDetails);
        return ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberService.delete(id);
        return ResponseEntity.ok().build();
    }
}
