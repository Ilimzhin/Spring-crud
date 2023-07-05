package com.example.springcruddemo.controller;

import com.example.springcruddemo.model.User;
import com.example.springcruddemo.model.UserSecurity;
import com.example.springcruddemo.repo.UserSecurityRepo;
import com.example.springcruddemo.service.UserSecurityService;
import com.example.springcruddemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    private UserSecurityService userSecurityService;
    private final UserSecurityRepo userSecurityRepo;

    public UserController(UserService userService,
                          UserSecurityRepo userSecurityRepo) {
        this.userService = userService;
        this.userSecurityRepo = userSecurityRepo;
    }

    @GetMapping("/users")
    public String findAll(Model model) {
        List<UserSecurity> userSecurities = userSecurityService.findAll();
        model.addAttribute("userSecurities", userSecurities);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

}
