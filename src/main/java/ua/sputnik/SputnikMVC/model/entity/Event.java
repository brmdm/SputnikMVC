package ua.sputnik.SputnikMVC.model.entity;

import javax.persistence.*;

/**
 * @author Barma
 */
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String date;
    private String time;

    private Integer price;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_id")
    private Film film;

    public Event() {
    }

    public Event(String date, String time, Integer price, Film film) {
        this.date = date;
        this.time = time;
        this.price = price;
        this.film = film;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
