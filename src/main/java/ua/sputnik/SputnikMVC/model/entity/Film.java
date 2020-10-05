package ua.sputnik.SputnikMVC.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Barma
 */
@Entity
public class Film {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;

    public Film() {

    }

    public Film(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
