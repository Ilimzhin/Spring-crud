package com.example.springcruddemo.repo;

import com.example.springcruddemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
//    List<User> findByLastName(String lastName);
}
