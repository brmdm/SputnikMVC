package ua.sputnik.SputnikMVC.model.repository;

import org.springframework.data.repository.CrudRepository;
import ua.sputnik.SputnikMVC.model.entity.Event;

import java.util.Optional;

/**
 * @author Barma
 */
public interface EventRepository extends CrudRepository<Event, Integer> {
    Optional<Event> findById (Long id);
}
