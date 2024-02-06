package com.makeup.domain;

import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Getter
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long calendarId;

    private String calendarInfo; // 캘린더 정보;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

}
