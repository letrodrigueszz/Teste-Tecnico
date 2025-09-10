package com.example.testetecnico.repository;

import com.example.testetecnico.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    @Query(value = "SELECT * FROM cards c WHERE c.user_id = ?1", nativeQuery = true)
    List<Card> findAllByUserIdNative(Long userId);
}
