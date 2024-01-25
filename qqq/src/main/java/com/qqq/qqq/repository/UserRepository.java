package com.qqq.qqq.repository;


import com.qqq.qqq.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
