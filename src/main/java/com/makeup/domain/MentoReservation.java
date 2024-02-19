package com.makeup.domain;

import com.makeup.controller.Form.MentoReservationForm;
import com.makeup.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter // 이 어노테이션 추가
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MentoReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mentoReservationId;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime mentoDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public static MentoReservation toMentoReservation(MentoReservationForm mentoform, Member member) {
        return MentoReservation.builder()
                .mentoDate(mentoform.getMentoDate())
                .member(member)
                .build();
    }
}
