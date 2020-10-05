package ua.sputnik.SputnikMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.sputnik.SputnikMVC.model.entity.Event;
import ua.sputnik.SputnikMVC.model.entity.Film;
import ua.sputnik.SputnikMVC.model.repository.EventRepository;
import ua.sputnik.SputnikMVC.model.repository.FilmRepository;

import java.util.Map;

/**
 * @author Barma
 */
@Controller
@RequestMapping("/event")
@PreAuthorize("hasAuthority('ADMIN')")
public class EventController {
    private EventRepository eventRepository;
    private FilmRepository filmRepository;
    @Autowired
    public EventController(EventRepository eventRepository, FilmRepository filmRepository) {
        this.eventRepository = eventRepository;
        this.filmRepository = filmRepository;
    }
    @GetMapping
    public String list(Model model) {
        Iterable<Event> events = eventRepository.findAll();

        model.addAttribute("events", events);
        return "event";
    }

    @PostMapping
    public String add(
            @RequestParam String date,
            @RequestParam String time,
            @RequestParam String film,
            @RequestParam Integer price, Map<String, Object> model) {
        Film filmDb = filmRepository.findByTitle(film);
        if (filmDb == null) {
            model.put("message", "Film not found. Try again!!!");
            return "event";
        }

        Event event = new Event(date, time, price, filmDb);
        eventRepository.save(event);
        Iterable<Event> events = eventRepository.findAll();
        model.put("events", events);

        return "event";
    }
}
