package ua.sputnik.SputnikMVC.controller;

/**
 * @author Barma
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.sputnik.SputnikMVC.model.entity.Message;
import ua.sputnik.SputnikMVC.model.entity.User;
import ua.sputnik.SputnikMVC.model.repository.MessageRepository;
import ua.sputnik.SputnikMVC.service.EventService;
import ua.sputnik.SputnikMVC.service.TicketService;

import java.util.Map;

@Controller
public class MainController {

    private MessageRepository messageRepo;
    private EventService eventService;
    private TicketService ticketService;

    @Autowired
    public MainController(MessageRepository messageRepo, EventService eventService, TicketService ticketService) {
        this.eventService = eventService;
        this.messageRepo = messageRepo;
        this.ticketService = ticketService;
    }

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("events", eventService.findAll());
        return "greeting";
    }

    @GetMapping("/main")
    public String mainPage(Model model) {

//        model.addAttribute("tickets", ticketService.findAllByUserId());
        model.addAttribute("tickets", ticketService.findAll());

        return "main";
    }

//    @GetMapping("/main")
//    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
//        Iterable<Message> messages = messageRepo.findAll();
//
//        if (filter != null && !filter.isEmpty()) {
//            messages = messageRepo.findByTag(filter);
//        } else {
//            messages = messageRepo.findAll();
//        }
//
//        model.addAttribute("messages", messages);
//        model.addAttribute("filter",filter);
//        model.addAttribute("tickets", ticketService.findAll());
//
//        return "main";
//    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag, user);

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

        return "main";
    }

}
