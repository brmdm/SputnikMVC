package ua.sputnik.SputnikMVC.model.entity;

import javax.persistence.*;

/**
 * @author Barma
 */
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    private Long seat;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id")
    private Event event;

    public Ticket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSeat() {
        return seat;
    }

    public void setSeat(Long seat) {
        this.seat = seat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
