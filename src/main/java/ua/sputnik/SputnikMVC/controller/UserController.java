package ua.sputnik.SputnikMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.sputnik.SputnikMVC.model.entity.Role;
import ua.sputnik.SputnikMVC.model.entity.User;
import ua.sputnik.SputnikMVC.model.repository.UserRepository;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Barma
 */
@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    private UserRepository userRepo;
    @Autowired
    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public String userList (Model model) {
        model.addAttribute("users", userRepo.findAll());
        return "userList";
    }


    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());

        return "userEdit";
    }

//    @GetMapping("{user}")
//    public String userEditForm(@PathVariable Long user, Model model) {
////        model.addAttribute("user",user);
////        Integer id = user != null ? user.intValue() : null;
////        model.addAttribute("usr", userRepo.findById(id));
//        model.addAttribute("roles", Role.values());
//        return "userEdit";
//    }

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ) {
        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepo.save(user);

        return "redirect:/user";
    }
}
