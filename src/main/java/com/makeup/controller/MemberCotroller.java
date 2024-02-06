package com.makeup.controller;


import com.makeup.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(" ")
@RequiredArgsConstructor
public class MemberCotroller {

    private final MemberService memberService;

}
