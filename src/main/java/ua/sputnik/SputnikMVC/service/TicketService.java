package ua.sputnik.SputnikMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.sputnik.SputnikMVC.model.entity.Message;
import ua.sputnik.SputnikMVC.model.entity.Ticket;
import ua.sputnik.SputnikMVC.model.entity.User;
import ua.sputnik.SputnikMVC.model.repository.TicketRepository;

import java.util.ArrayList;

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

    public void addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public boolean deleteTicket() {
        return false;
    }

    public Ticket findById (Long id) {
        return null;
    }

    public Iterable<Ticket> findAllByUserId (long userId) {
        long id;
        ArrayList userTickets = new ArrayList<>();
        Iterable<Ticket> allTickets = ticketRepository.findAll();
        for (Ticket t: allTickets) {
            id = t.getUser().getId();
            if (id == userId) {
                userTickets.add(t);
            }
        }


        return userTickets;
    }

    public Ticket findByEventId (Long id) {
        return null;
    }

    public Iterable<Ticket> findAll() {
        return ticketRepository.findAll();
    }
}
