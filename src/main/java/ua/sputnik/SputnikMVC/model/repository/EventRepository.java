package ua.sputnik.SputnikMVC.model.repository;

import org.springframework.data.repository.CrudRepository;
import ua.sputnik.SputnikMVC.model.entity.Event;

/**
 * @author Barma
 */
public interface EventRepository extends CrudRepository<Event, Integer> {
    Event findById (Long id);
}
