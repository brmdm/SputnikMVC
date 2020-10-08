package ua.sputnik.SputnikMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.sputnik.SputnikMVC.model.entity.Film;
import ua.sputnik.SputnikMVC.model.repository.FilmRepository;

/**
 * @author Barma
 */
@Service
public class FilmService {
    private FilmRepository filmRepository;
    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public void addFilm(Film film) {
        filmRepository.save(film);
    }

    public Film findByTitle(String title) {
        return filmRepository.findByTitle(title);
    }

    public Iterable<Film> findAll() {
        return filmRepository.findAll();
    }
}
