package ua.sputnik.SputnikMVC.model.repository;

import org.springframework.data.repository.CrudRepository;
import ua.sputnik.SputnikMVC.model.entity.Message;

import java.util.List;

/**
 * @author Barma
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {
    List<Message> findByTag(String tag);
}
