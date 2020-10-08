package ua.sputnik.SputnikMVC.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import ua.sputnik.SputnikMVC.model.entity.Event;

import java.util.Optional;

/**
 * @author Barma
 */
public interface EventRepository extends CrudRepository<Event, Integer> {

    Page<Event> findAll(Pageable pageable);
    Optional<Event> findById (Long id);

}
