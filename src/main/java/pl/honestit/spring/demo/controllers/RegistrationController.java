package pl.honestit.spring.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.honestit.spring.demo.model.dal.UserRepository;
import pl.honestit.spring.demo.model.domain.User;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String prepareRegistrationPage() {
        return "/WEB-INF/views/registration-page.jsp";
    }

    @PostMapping
    public String processRegistrationPage(String username,
                                          String password,
                                          String firstName,
                                          String lastName) {
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        userRepository.save(user);
        return "redirect:/index.html";
    }

}