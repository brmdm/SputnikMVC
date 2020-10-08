package ua.sputnik.SputnikMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.sputnik.SputnikMVC.model.entity.Ticket;
import ua.sputnik.SputnikMVC.model.repository.TicketRepository;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    public Optional<Ticket> findById(Long id) {
        return ticketRepository.findById(id);
    }

    public void deleteAllTicketByEventId(Long id) {
        Ticket ticket = null;
        try {
            ticket = ticketRepository.findTopByEvent_Id(id).get();
        } catch (NoSuchElementException e) {

        }

        for (int i = 0; ticket != null; i++) {
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

    public Ticket findByEventId(Long id) {
        return null;
    }

    public Iterable<Ticket> findAll() {
        return ticketRepository.findAll();
    }
}
