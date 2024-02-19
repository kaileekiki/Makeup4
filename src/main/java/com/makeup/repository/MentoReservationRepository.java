package com.makeup.repository;

import com.makeup.domain.Member;
import com.makeup.domain.MentoReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MentoReservationRepository extends JpaRepository<MentoReservation, Long> {
    @Query("select m from MentoReservation m  where m.member = :member")
    List<MentoReservation> findByMember(Member member);
}
