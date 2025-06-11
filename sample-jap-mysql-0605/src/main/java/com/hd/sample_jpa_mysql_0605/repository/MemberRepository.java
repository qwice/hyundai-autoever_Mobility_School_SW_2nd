package com.hd.sample_jpa_mysql_0605.repository;

import com.hd.sample_jpa_mysql_0605.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // 이메일 존재 여부 확인 : 존재하면 true
    boolean existsByEmail(String email);

    // 이메일로 회원 정보 가져 오기, Optional은 null을 처리하기 위해서 사용
    Optional<Member> findByEmail(String email);

    // 로그인을 성공 실패를 위해 email과 pwd가 존재하는지
    Optional<Member> findByEmailAndPwd(String email, String pwd);
}
