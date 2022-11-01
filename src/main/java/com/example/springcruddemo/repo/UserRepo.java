package com.example.springcruddemo.repo;

import com.example.springcruddemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
//    List<User> findByLastName(String lastName);
}
