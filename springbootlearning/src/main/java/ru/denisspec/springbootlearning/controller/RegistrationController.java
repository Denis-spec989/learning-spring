package ru.denisspec.springbootlearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.denisspec.springbootlearning.domain.Role;
import ru.denisspec.springbootlearning.domain.User;
import ru.denisspec.springbootlearning.repository.UserRepository;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    private UserRepository userRepository;
    @Autowired
    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/registration")
    public String registration()
    {
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(User user, Map<String,Object> model)
    {
        User userFromDB = userRepository.findByUsername(user.getUsername());
        if(userFromDB != null)
        {
            model.put("message","User exists!");
                    return "registration";
        }
        user.setActive(true);
        user.setRole(Collections.singleton(Role.USER));
        userRepository.save(user);
        return "redirect:/login";
    }
}
