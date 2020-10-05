package ua.sputnik.SputnikMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.sputnik.SputnikMVC.model.entity.Event;
import ua.sputnik.SputnikMVC.model.repository.EventRepository;
import ua.sputnik.SputnikMVC.model.repository.TicketRepository;

/**
 * @author Barma
 */
@Service
public class EventService {
    private EventRepository eventRepository;
    private TicketRepository ticketRepository;
    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public boolean addEvent() {
        return false;
    }

    public boolean deleteEvent(Long id) {
        return false;
    }

    public Event findById (Long id) {
        return null;
    }

    public int[] findFreeSeats () {
        return null;
    }

    public Iterable<Event> findAll() {
        return eventRepository.findAll();
    }
}
