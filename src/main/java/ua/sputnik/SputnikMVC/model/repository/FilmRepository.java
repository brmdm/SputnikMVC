package ua.sputnik.SputnikMVC.model.repository;

import org.springframework.data.repository.CrudRepository;
import ua.sputnik.SputnikMVC.model.entity.Film;

/**
 * @author Barma
 */
public interface FilmRepository extends CrudRepository<Film, Integer> {
    Film findByTitle(String title);
}
