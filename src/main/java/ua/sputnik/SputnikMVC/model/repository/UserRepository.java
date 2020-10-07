package ua.sputnik.SputnikMVC.model.repository;

/**
 * @author Barma
 */
import org.springframework.data.jpa.repository.JpaRepository;

import ua.sputnik.SputnikMVC.model.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
