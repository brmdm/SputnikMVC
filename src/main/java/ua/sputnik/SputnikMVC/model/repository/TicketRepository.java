package ua.sputnik.SputnikMVC.model.repository;

import org.springframework.data.repository.CrudRepository;
import ua.sputnik.SputnikMVC.model.entity.Ticket;

import java.util.Optional;

/**
 * @author Barma
 */
public interface TicketRepository extends CrudRepository<Ticket, Integer> {
    Optional<Ticket> findById(Long id);
    Optional<Ticket> findTopByEvent_Id(Long id);
}
