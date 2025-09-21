package com.example.testetecnico.repository;

import com.example.testetecnico.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM users u WHERE u.email = :email", nativeQuery = true)
    User findByEmailNative(@Param("email") String email);
}


