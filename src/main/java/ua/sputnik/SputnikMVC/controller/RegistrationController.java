package ua.sputnik.SputnikMVC.controller;


/**
 * @author Barma
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.sputnik.SputnikMVC.model.entity.Role;
import ua.sputnik.SputnikMVC.model.entity.User;
import ua.sputnik.SputnikMVC.model.repository.UserRepository;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    private UserRepository userRepo;

    @Autowired
    public RegistrationController(UserRepository userRepo) {
        this.userRepo = userRepo;
        User userFromDb = userRepo.findByUsername("admin");
        if (userFromDb == null) {
            User admin = new User();
            admin.setRoles(Collections.singleton(Role.ADMIN));
            admin.setUsername("admin");
            admin.setPassword("admin");
            userRepo.save(admin);
        }
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);


        return "redirect:/login";
    }
}
