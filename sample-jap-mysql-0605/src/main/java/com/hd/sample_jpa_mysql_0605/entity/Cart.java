package com.hd.sample_jpa_mysql_0605.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cart")
@Getter
@Setter
@ToString
public class Cart {
    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 128, nullable = false)
    private String cartName;

    @OneToOne // 회원 엔티티와 일대일 매핑
    @JoinColumn(name = "member_id")
    private Member member;
}
