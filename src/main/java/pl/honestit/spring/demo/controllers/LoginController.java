package pl.honestit.spring.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.honestit.spring.demo.model.domain.User;
import pl.honestit.spring.demo.model.repositories.UserRepository;


@Controller
    @RequestMapping("/login")
    public class LoginController {


    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public LoginController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String preparepLoginPage() {
        return "login-page";
    }

    @PostMapping
    public String processLoginPage(String username,
                                   String password,
                                   String firstName,
                                   String lastName) {
        {
            User user = new User();
            user.setPassword(password);
            user.setUsername(username);
            user.setFirstName(firstName);
            user.setLastName(lastName);

            userRepository.save(user);
            return "login-page";
        }
    }
}



