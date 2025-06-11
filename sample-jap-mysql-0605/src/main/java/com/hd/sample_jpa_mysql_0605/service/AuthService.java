package com.hd.sample_jpa_mysql_0605.service;

import com.hd.sample_jpa_mysql_0605.dto.MemberReqDto;
import com.hd.sample_jpa_mysql_0605.entity.Member;
import com.hd.sample_jpa_mysql_0605.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j // log 정보를 출력하기 위한 롬복의 어노테이션
@Service //Spring Container에 Bean 등록
@Transactional // 여러개의 물리적 잡업 단위를 논리적 단위로 묶음
@RequiredArgsConstructor // 생성자를 자동 생성
public class AuthService {
    private final MemberRepository memberRepository; // 생성자를 통한 의존성 주입 받음

    // 회원 가입 여부 확인
    public boolean isMember(String email) {
        return memberRepository.existsByEmail(email);
    }

    // 회원 가입
    public boolean signup(MemberReqDto memberReqDto) {
        try {
            Member member = convertDtoToEntity(memberReqDto);
            memberRepository.save(member);
            return true;
        } catch (Exception e) {
            log.error("회원가입 시 오류 발생 {}", e.getMessage());
            return false;
        }
    }
    // 로그인
    public boolean login(String email, String pwd) {
        // isPresent() : 객체가 있으면
        Optional<Member> member = memberRepository.findByEmailAndPwd(email, pwd);
        return member.isPresent(); // 객체 존재 여부 확인
    }

    // DTO -> Entity Mapping
    private Member convertDtoToEntity(MemberReqDto memberReqDto) {
        Member member = new Member();
        member.setEmail(memberReqDto.getEmail());
        member.setPwd(memberReqDto.getPwd());
        member.setName(memberReqDto.getName());
        return member;
    }
}
