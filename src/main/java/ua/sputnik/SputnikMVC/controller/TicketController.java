package ua.sputnik.SputnikMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.sputnik.SputnikMVC.model.entity.Event;
import ua.sputnik.SputnikMVC.model.entity.Ticket;
import ua.sputnik.SputnikMVC.model.entity.User;
import ua.sputnik.SputnikMVC.service.EventService;
import ua.sputnik.SputnikMVC.service.TicketService;
import ua.sputnik.SputnikMVC.service.UserService;

/**
 * @author Barma
 */
@Controller
@RequestMapping("/ticket")
public class TicketController {
    private TicketService ticketService;
    private UserService userService;
    private EventService eventService;
    @Autowired
    public TicketController(TicketService ticketService, UserService userService, EventService eventService) {
        this.ticketService = ticketService;
        this.userService = userService;
        this.eventService = eventService;
    }

    @GetMapping("{id}")
    public String ordering(@PathVariable Long id, Model model) {
        Event event = eventService.findById(id);
        model.addAttribute("event", event);
        return "ticket";
    }

    @PostMapping
    public String buy(
            @RequestParam("eventId") String event,
            @RequestParam("userName") String user,
            @RequestParam("seat") Long seat) {

        // TODO : Check free seat

        if (seat > 0 && seat < 16) {
            Ticket ticket = new Ticket(seat,
                    userService.findByUsername(user),
                    eventService.findById(Long.parseLong(event)));


            ticketService.addTicket(ticket);
        }
        return "redirect:/main";
    }


}
