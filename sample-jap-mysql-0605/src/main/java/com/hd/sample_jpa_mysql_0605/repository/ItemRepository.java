package com.hd.sample_jpa_mysql_0605.repository;

import com.hd.sample_jpa_mysql_0605.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // 기본적인 CRUD는 이미 만들어져 있음
    List<Item> findByItemNm(String itemNm); // SELECT * from item where item_nm = itemNm
    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);

    // @Query : JPQL, nativeQuery
    // JPQL : 객체 지향 언어로 쿼리를 작성, 쿼리 메서드로 작성하기 힘든 복잡한 쿼리 작성 가능, JPQL 문법 숙지
    @Query("SELECT i FROM Item i WHERE i.itemDetail like %:itemDetail% ORDER BY i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

    //nativeQuery : 해당하는 DB의 실제 쿼리를 작성, 복잡한 쿼리 작성 가능
    @Query(value = "SELECT * FROM item i WHERE i.item_detail like %:itemDetail% ORDER BY i.price desc", nativeQuery = true)
    List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);
}
