package com.hd.sample_jpa_mysql_0605.repository;

import com.hd.sample_jpa_mysql_0605.entity.Cart;
import com.hd.sample_jpa_mysql_0605.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

@Slf4j // Log 메세지를 출력하기 위해서 사용하는 롬복의 어노테이션
@SpringBootTest
@Transactional // 트랜젝션 처리, 여러개의 작업을 하나의 논리적인 작업 단위로 묶어줌, 테스트 완료 후 자동 롤백(성공, 실패 상관없이)
@TestPropertySource(locations = "classpath:application-test.properties")
class CartRepositoryTest {
    @Autowired // 의존성 주입을 받음, 생성자를 통한 의존성 주입인 경우는 어노테이션 필요 없음.
    CartRepository cartRepository;

    @Autowired
    MemberRepository memberRepository;

    @PersistenceContext // JPA의 Entity Manager, 영속성?
    EntityManager em;

    // 회원 엔티티 생성
    public Member createMember() {
        Member member = new Member();
        member.setEmail("jsk9061@naver.com");
        member.setName("jsk");
        member.setPwd("1234");
        member.setRegDate(LocalDateTime.now());
        return member;
    }

    @Test
    @DisplayName("장바구니와 회원 매핑 조회 테스트")
    public void findCartAndMemberTest() {
        Member member = createMember();
        memberRepository.save(member);

        Cart cart = new Cart();
        cart.setCartName("자동차 구매 장바구나");
        cart.setMember(member);
        cartRepository.save(cart);

        em.flush(); // 영속성 컨텍스트에 저장된 내용을 DB에 반영
        em.clear(); // 영속성 컨텍스트 메모리 비움

        Cart saveCart = cartRepository.findById(cart.getId()).orElseThrow(EntityNotFoundException::new);

        log.info("Cart : {}", saveCart);

    }

}