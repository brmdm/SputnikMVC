package ua.sputnik.SputnikMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.sputnik.SputnikMVC.model.entity.Ticket;
import ua.sputnik.SputnikMVC.model.repository.TicketRepository;

import java.util.ArrayList;
import java.util.NoSuchElementException;

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

    public Iterable<Ticket> findAllTicketByEventId(Long id) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        Ticket ticket = null;
        try {
            ticket = ticketRepository.findTopByEvent_Id(id).get();
            tickets.add(ticket);
        } catch (NoSuchElementException e) { }

        for ( ; ticket != null; ) {
            try {
                ticket = ticketRepository.findTopByEvent_Id(id).get();
                tickets.add(ticket);
            } catch (NoSuchElementException e) {
                break;
            }
        }

        return tickets;
    }

    public void deleteAllTicketByEventId(Long id) {
        Ticket ticket = null;
        try {
            ticket = ticketRepository.findTopByEvent_Id(id).get();
        } catch (NoSuchElementException e) { }

        for ( ; ticket != null; ) {
            ticketRepository.delete(ticket);
            try {
                ticket = ticketRepository.findTopByEvent_Id(id).get();
            } catch (NoSuchElementException e) {
                break;
            }
        }
    }

    public Iterable<Ticket> findAllByUserId(long userId) {
        long id;
        ArrayList userTickets = new ArrayList<>();
        Iterable<Ticket> allTickets = ticketRepository.findAll();
        for (Ticket t : allTickets) {
            id = t.getUser().getId();
            if (id == userId) {
                userTickets.add(t);
            }
        }
        return userTickets;
    }
}
