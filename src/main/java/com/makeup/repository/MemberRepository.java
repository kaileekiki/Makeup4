package com.makeup.repository;

import com.makeup.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);

    boolean existsByEmail(String email);

    @Query("select m from Member m where m.email = :email and m.password = :password")
    Optional<Member> findMemberByEmailAndPassword(String email, String password);

    @Query("select m from Member m  where m.memberId = :memberId")
    Optional<Member> findMemberById(Long memberId);
}
