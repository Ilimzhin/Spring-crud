package com.example.springcruddemo.repo;

import com.example.springcruddemo.model.UserSecurity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSecurityRepo extends JpaRepository<UserSecurity, Long> {
    UserSecurity findByEmail(String email);

}
