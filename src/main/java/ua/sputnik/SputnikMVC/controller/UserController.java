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


}
