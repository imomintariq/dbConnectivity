package Entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "turn", indexes = {
        @Index(name = "memberIDfk_idx", columnList = "memberID")
})
public class Turn {
    @Id
    @Column(name = "turnID", nullable = false)
    private Integer id;

    @Column(name = "turnDate", nullable = false)
    private LocalDate turnDate;

    @Column(name = "turnStatus", nullable = false, length = 10)
    private String turnStatus;

    @ManyToOne
    @JoinColumn(name = "memberID")
    private Member memberID;

    @Column(name = "turnNumber", nullable = false)
    private Integer turnNumber;

    public Integer getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(Integer turnNumber) {
        this.turnNumber = turnNumber;
    }

    public Member getMemberID() {
        return memberID;
    }

    public void setMemberID(Member memberID) {
        this.memberID = memberID;
    }

    public String getTurnStatus() {
        return turnStatus;
    }

    public void setTurnStatus(String turnStatus) {
        this.turnStatus = turnStatus;
    }

    public LocalDate getTurnDate() {
        return turnDate;
    }

    public void setTurnDate(LocalDate turnDate) {
        this.turnDate = turnDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}