package ua.sputnik.SputnikMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.sputnik.SputnikMVC.model.entity.Film;
import ua.sputnik.SputnikMVC.service.FilmService;

import java.util.Map;

/**
 * @author Barma
 */
@Controller
@RequestMapping("/film")
@PreAuthorize("hasAuthority('ADMIN')")
public class FilmController {
    private FilmService filmService;
    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("films", filmService.findAll());
        return "film";
    }

    @PostMapping
    public String add(
            @RequestParam String title,
            @RequestParam String description, Map<String, Object> model) {
        Film film = new Film(title, description);

        filmService.addFilm(film);

        model.put("films", filmService.findAll());

        return "film";
    }
}
