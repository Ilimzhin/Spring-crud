package com.example.springcruddemo.controller;

import com.example.springcruddemo.model.UserSecurity;
import com.example.springcruddemo.repo.UserSecurityRepo;
import com.example.springcruddemo.service.UserSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
public class UserSecurityController {
    @Autowired
    private final UserSecurityService userSecurityService;
    private final UserSecurityRepo userSecurityRepo;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/products";
    }


    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }


    @PostMapping("/registration")
    public String createUser(UserSecurity userSecurity, Model model) {
        if (userSecurityService.createUserSecurity(userSecurity)) {
            model.addAttribute("errorMessage", "Пользователь с Email" + userSecurity.getEmail() + "Уже существует");
            return "registration";
        }
        userSecurityRepo.save(userSecurity);
        return "redirect:/login";
    }

    @GetMapping("/hello")
    public String securityUrl()  {
        return "hello";
    }
}
