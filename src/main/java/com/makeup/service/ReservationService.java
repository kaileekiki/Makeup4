package com.makeup.service;

import com.makeup.controller.Form.MenteeReservationForm;
import com.makeup.controller.Form.MentoReservationForm;
import com.makeup.domain.Member;
import com.makeup.domain.MenteeReservation;
import com.makeup.domain.MentoReservation;
import com.makeup.dto.MemberDto;
import com.makeup.dto.MenteeReservationDto;
import com.makeup.dto.ReservationDto;
import com.makeup.repository.MemberRepository;
import com.makeup.repository.MenteeReservationRepository;
import com.makeup.repository.MentoReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.makeup.exception.MemberNotFoundException;
import com.makeup.exception.ReservationNotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.member;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final MentoReservationRepository mentoReservationRepository;
    private final MemberRepository memberRepository;
    private final MenteeReservationRepository menteeReservationRepository;
    public Long addReservationDate(MentoReservationForm form) {
        Member member =
                memberRepository.findById(form.getMemberId()).orElseThrow(MemberNotFoundException::new);
        MentoReservation mentoReservation = mentoReservationRepository.save(MentoReservation.toMentoReservation(form, member));
        return mentoReservation.getMentoReservationId();
    }

    public List<ReservationDto> findAll(Long memberId) {
        Member mento = memberRepository
                .findMemberById(memberId)
                .orElseThrow(MemberNotFoundException::new);;

        List<MentoReservation> mentoReservationList = mentoReservationRepository
                .findByMember(mento);
        //Controller로 dto로 변환해서 줘야 함


        List<ReservationDto> reservationDtoList = new ArrayList<>();
        for (MentoReservation mentoReservation : mentoReservationList){
            reservationDtoList.add(ReservationDto.MentoFrom(mentoReservation));

        }
        return reservationDtoList;
    }

    public void deleteReservation(Long mentoReservationId) {
        mentoReservationRepository.deleteById(mentoReservationId);
    }

    public Long menteeReservation(MenteeReservationDto menteeReservationDto) {
        MentoReservation mentoReservation =
                mentoReservationRepository.findById(menteeReservationDto.getMentoReservationId()).orElseThrow(ReservationNotFoundException::new);

        Member mento =
                mentoReservation.getMember();

        LocalDateTime date =
                mentoReservation.getMentoDate();

        Member mentee =
                memberRepository.findById(menteeReservationDto.getMemberId()).orElseThrow(MemberNotFoundException::new);

        MenteeReservation menteeReservation = menteeReservationRepository.save(MenteeReservation.toMenteeReservation(date, mento, mentee));
        return menteeReservation.getReservationId();
    }

}
