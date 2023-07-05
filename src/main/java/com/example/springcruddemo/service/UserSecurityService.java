package com.example.springcruddemo.service;

import com.example.springcruddemo.model.User;
import com.example.springcruddemo.model.UserSecurity;
import com.example.springcruddemo.model.enums.Role;
import com.example.springcruddemo.repo.UserRepo;
import com.example.springcruddemo.repo.UserSecurityRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserSecurityService {
    private final UserSecurityRepo userSecurityRepo;
    private final PasswordEncoder passwordEncoder;

//    @Autowired
//    public UserSecurityService(UserSecurityRepo userSecurityRepo) {
//        this.userSecurityRepo = userSecurityRepo;
//    }
    public boolean createUserSecurity(UserSecurity userSecurity) {
        String email = userSecurity.getEmail();
        if (userSecurityRepo.findByEmail(email) != null) return false;
        userSecurity.setActive(true);
        userSecurity.setPassword(passwordEncoder.encode(userSecurity.getPassword()));
        userSecurity.getRoles().add(Role.ROLE_USER);
        log.info("Saving New User with email: {}", email);
        userSecurityRepo.save(userSecurity);
        return true;
    }

    public List<UserSecurity> findAll() {
        return userSecurityRepo.findAll();
    }

    public UserSecurity saveUserSecurity(UserSecurity userSecurity) {
        return userSecurityRepo.save(userSecurity);
    }


}
