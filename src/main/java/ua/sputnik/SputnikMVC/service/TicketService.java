package ua.sputnik.SputnikMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.sputnik.SputnikMVC.model.entity.Ticket;
import ua.sputnik.SputnikMVC.model.repository.TicketRepository;

/**
 * @author Barma
 */
@Service
public class TicketService {
    private TicketRepository ticketRepository;
    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public boolean addTicket() {
        return false;
    }

    public boolean deleteTicket() {
        return false;
    }

    public Ticket findById (Long id) {
        return null;
    }

    public Ticket findByEventId (Long id) {
        return null;
    }

    public Iterable<Ticket> findAll() {
        return ticketRepository.findAll();
    }
}
