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
import ua.sputnik.SputnikMVC.service.EventService;
import ua.sputnik.SputnikMVC.service.FilmService;

import java.util.Map;

/**
 * @author Barma
 */
@Controller
@RequestMapping("/event")
@PreAuthorize("hasAuthority('ADMIN')")
public class EventController {
    private EventService eventService;
    private FilmService filmService;

    @Autowired
    public EventController(EventService eventService, FilmService filmService) {
        this.eventService = eventService;
        this.filmService = filmService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("events", eventService.findAll());
        return "event";
    }

    @PostMapping
    public String add(
            @RequestParam String date,
            @RequestParam String time,
            @RequestParam String film,
            @RequestParam Integer price, Map<String, Object> model) {
        Film filmDb = filmService.findByTitle(film);
        if (filmDb == null) {
            model.put("message", "Film not found. Try again!!!");
            return "event";
        }

        Event event = new Event(date, time, price, filmDb);
        eventService.addEvent(event);
        model.put("events", eventService.findAll());

        return "event";
    }

    @PostMapping("/delete")
    public String deleteEvent(@RequestParam String eventId, Model model) {
        eventService.deleteEvent(Long.parseLong(eventId));
        model.addAttribute("events", eventService.findAll());
        return "event";
    }
}
