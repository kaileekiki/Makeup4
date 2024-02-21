package com.makeup.domain;

import com.makeup.controller.Form.MentoReservationForm;
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
public class MenteeReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mento_id")
    private Member mento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentee_id")
    private Member mentee;

    public static MenteeReservation toMenteeReservation(LocalDateTime date, Member mento, Member mentee) {
        return MenteeReservation.builder()
                .date(date)
                .mento(mento)
                .mentee(mentee)
                .build();
    }
}

