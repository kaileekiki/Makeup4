package com.makeup.service;

import com.makeup.controller.Form.MentoReservationForm;
import com.makeup.domain.Member;
import com.makeup.domain.MentoReservation;
import com.makeup.dto.MemberDto;
import com.makeup.dto.ReservationDto;
import com.makeup.repository.MemberRepository;
import com.makeup.repository.MentoReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.makeup.exception.MemberNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final MentoReservationRepository mentoReservationRepository;
    private final MemberRepository memberRepository;
    public Long addReservationDate(MentoReservationForm form) {
        Member member =
                memberRepository.findById(form.getMemberId()).orElseThrow(MemberNotFoundException::new);
        MentoReservation mentoReservation = mentoReservationRepository.save(MentoReservation.toMentoReservation(form, member));
        return mentoReservation.getMentoReservationId();
    }

    public List<ReservationDto> findAll(Long mentoReservationId) {
        Member mento = memberRepository
                .findMemberById(mentoReservationId)
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

}
