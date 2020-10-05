package ua.sputnik.SputnikMVC.service;

import org.springframework.stereotype.Service;
import ua.sputnik.SputnikMVC.model.repository.EventRepository;

/**
 * @author Barma
 */
@Service
public class EventService {
    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
}
