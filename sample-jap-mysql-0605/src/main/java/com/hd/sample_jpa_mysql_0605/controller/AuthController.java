package com.hd.sample_jpa_mysql_0605.controller;

import com.hd.sample_jpa_mysql_0605.dto.LoginReqDto;
import com.hd.sample_jpa_mysql_0605.dto.MemberReqDto;
import com.hd.sample_jpa_mysql_0605.dto.MemberResDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {
    @PostMapping("/signup")
    public ResponseEntity<MemberResDto> signup(@RequestBody MemberReqDto memberReqDto){
        log.info("member : {}",memberReqDto);
        MemberResDto memberResDto = new MemberResDto();
        memberResDto.setEmail(memberReqDto.getEmail());
        memberResDto.setName(memberReqDto.getName());
        memberResDto.setPwd(memberReqDto.getPwd());
        memberResDto.setImage("/test/test.img");
        memberResDto.setRegDate(LocalDateTime.now());


        return ResponseEntity.ok(memberResDto);
    }

    // 로그인
    // Post 방식 : email, pwd를 Request Body 형식으로 수신
    // 응답은 boolean 값으로 응답
    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody LoginReqDto loginReqDto){
        log.info("member : {}",loginReqDto);
        return ResponseEntity.ok(true);
    }

    // 회원 조회
    // Get 방식 : email이 있으면 해당 회원 조회
    // 없으면 전체 회원 조회
    // 단 회원 정보 리스트는 서비스로직과 DB가 없으므로, for문으로 자체 생성
    private final List<MemberResDto> memberResDtoList = new ArrayList<>();
    private List<MemberResDto> generateMember() {
        for(int i = 0 ; i < 20 ; i++){
            MemberResDto memberResDto = new MemberResDto();
            memberResDto.setEmail("email"+i+"@email.com");
            memberResDto.setName("name"+i);
            memberResDto.setPwd("pwd"+i);
            memberResDto.setImage("/test/test.img");
            memberResDto.setRegDate(LocalDateTime.now());
            memberResDtoList.add(memberResDto);
        }
        return memberResDtoList;
    }

    @GetMapping("list")
    public ResponseEntity<?> getMemberList(@RequestParam(required = false) String email) {
        List<MemberResDto> ls = generateMember();
        if(email == null || email.isBlank()) {
            return ResponseEntity.ok(ls);
        }
        for(MemberResDto memberResDto : ls) {
            if(memberResDto.getEmail().equals(email)) {
                return ResponseEntity.ok(memberResDto);
            }
        }
        return ResponseEntity.notFound().build();
    }
}
