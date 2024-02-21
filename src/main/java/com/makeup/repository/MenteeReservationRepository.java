package com.makeup.repository;

import com.makeup.domain.MenteeReservation;
import com.makeup.domain.MentoReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenteeReservationRepository extends JpaRepository<MenteeReservation, Long> {
}
