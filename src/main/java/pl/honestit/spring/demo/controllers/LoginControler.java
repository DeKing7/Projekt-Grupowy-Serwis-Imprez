package pl.honestit.spring.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.honestit.spring.demo.model.repositories.UserRepository;


@Controller
    @RequestMapping("/login")
    public class LoginControler {


        private UserRepository userRepository;

        private PasswordEncoder passwordEncoder;

        @Autowired
        public LoginControler(UserRepository userRepository, PasswordEncoder passwordEncoder) {
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
        }

        @GetMapping
        public String preparepLoginPage() {
            return "/WEB-INF/views/login-page.jsp";
        }

        @PostMapping
        public String processLoginPage(String username,
                                              String password,
                                              String firstName,
                                              String lastName) {

            return "redirect:/home-page.jsp.html";
        }

    }

