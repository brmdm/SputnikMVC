package ua.sputnik.SputnikMVC.model.repository;

import org.springframework.data.repository.CrudRepository;
import ua.sputnik.SputnikMVC.model.entity.Ticket;

/**
 * @author Barma
 */
public interface TicketRepository extends CrudRepository<Ticket, Integer> {
}
