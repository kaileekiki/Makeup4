package com.makeup.repository;

import com.makeup.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // 여기에 필요한 메소드를 추가할 수 있습니다. 예를 들어:

    // 사용자 이름으로 Member 찾기
    Member findByUsername(String username);

    // 이메일로 Member 찾기
    Member findByEmail(String email);

    // 닉네임으로 Member 찾기
    Member findByNickname(String nickname);
}
