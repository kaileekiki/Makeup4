package com.makeup.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Post extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    // 사진에 대한 변수 선언을 아직 하지 않음, 사진을 어떻게 처리할지 알아야함.
    private String title;
    private String content;
    private Boolean isAnonymous;
    private int likeCount;
    private int hashTag;
    private String memberInfo;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}



// 아직 미완성 코드
/*
    public static Post toPost(PostDto postDto, Member member) {
        return Post.builder()
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .isAnonymous(postDto.isAnonymous())
                .member(member)
                .build();
    }
}
*/