package com.makeup.repository;

import com.makeup.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUsername(String username);

    @Query("select m from Member m where m.username = :username and m.password = :password")
    Optional<Member> findMemberByUsernameAndPassword(String username, String password);
}
