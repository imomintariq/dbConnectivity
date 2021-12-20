package Entities;

import javax.persistence.*;

@Entity
@Table(name = "member")
public class Member {
    @Id
    @Column(name = "idmember", nullable = false)
    private Integer id;

    @Column(name = "turnNumber")
    private Integer turnNumber;

    @ManyToOne
    @JoinColumn(name = "username")
    private User username;

    @ManyToOne
    @JoinColumn(name = "kametiId")
    private Kameti kametiId;

    public Kameti getKametiId() {
        return kametiId;
    }

    public void setKametiId(Kameti kametiId) {
        this.kametiId = kametiId;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public Integer getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(Integer turnNumber) {
        this.turnNumber = turnNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}