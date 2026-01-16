package com.backend.demo.repository;

import com.backend.demo.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface OrderRepository extends JpaRepository<Order,Integer> {
    Page<Order> findByUser_Id(int userId, Pageable pageable);
    @Query("""
   SELECT o FROM Order o
   WHERE o.user.id = :userId
   AND (:keyword IS NULL OR LOWER(o.productName)
       LIKE LOWER(CONCAT('%', :keyword, '%')))
   AND (:minPrice IS NULL OR o.price >= :minPrice)
   AND (:maxPrice IS NULL OR o.price <= :maxPrice)
""")
    Page<Order> searchOrdersByUser(@Param("userId")int userId,@Param("keyword") String keyword,
                                   @Param("minPrice")Integer minPrice,@Param("maxPrice") Integer maxPrice,
                                   Pageable pageable);

}
