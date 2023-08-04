package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Securities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SecuritiesRepository extends JpaRepository<Securities, Integer> {
    @Query(nativeQuery = true,
            value = "select * from securities where " +
                    "CAST(mature_date AS int) >= DATE_SUB(:CAST(today_date AS int), INTERVAL 5 DAY) and" +
                    "CAST(mature_date AS int) <= DATE_ADD(:CAST(today_date AS int), INTERVAL 5 DAY)")
    List<Securities> findByRecentAndNearMaturity(String today_date);

    @Query(nativeQuery = true,
            value = "select * from securities where " +
                    "mature_date >= :start_date and" +
                    "mature_date <= :end_date")
    List<Securities> findBySpecificDates(Securities start_date, Securities end_date);
}
