package com.korayaks.springbootjwt.repo;

import com.korayaks.springbootjwt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
