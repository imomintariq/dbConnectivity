package Entities;

import javax.persistence.*;

@Entity
@Table(name = "member", indexes = {
        @Index(name = "username_idx", columnList = "username"),
        @Index(name = "kametiId_idx", columnList = "kametiId")
})
public class Member {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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

    @Column(name = "isHead", length = 45)
    private String isHead;

    @Column(name = "hasPaid", length = 45)
    private String hasPaid;

    public String getHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(String hasPaid) {
        this.hasPaid = hasPaid;
    }

    public String getIsHead() {
        return isHead;
    }

    public void setIsHead(String isHead) {
        this.isHead = isHead;
    }

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