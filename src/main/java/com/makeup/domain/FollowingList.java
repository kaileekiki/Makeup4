package com.makeup.domain;

import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Getter
public class FollowingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long followingListid;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

}
