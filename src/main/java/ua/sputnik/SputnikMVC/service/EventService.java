package ua.sputnik.SputnikMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.sputnik.SputnikMVC.model.entity.Event;
import ua.sputnik.SputnikMVC.model.entity.Ticket;
import ua.sputnik.SputnikMVC.model.repository.EventRepository;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Barma
 */
@Service
public class EventService {
    private EventRepository eventRepository;
    private TicketService ticketService;

    @Autowired
    public EventService(EventRepository eventRepository, TicketService ticketService) {
        this.eventRepository = eventRepository;
        this.ticketService = ticketService;
    }

    public void addEvent(Event event) {
        eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        ticketService.deleteAllTicketByEventId(id);
        eventRepository.delete(event.get());
    }

    public Optional<Event> findById (Long id) {
        return eventRepository.findById(id);
    }

    public int[] findFreeSeatsByEventId (Long id) {
        Iterable<Ticket> ticket = ticketService.findAllTicketByEventId(id);


        return null;
    }

    public Page<Event> findAll(Pageable pageable) {
        return eventRepository.findAll(pageable);
    }

    public Iterable<Event> findAll() {
        return eventRepository.findAll();
    }
}
