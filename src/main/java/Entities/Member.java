package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class Member  {
    @Id
    @Column(name = "idMember", nullable = false)
    private Integer id;

    @Column(name = "turnNum")
    private Integer turnNum;

    public Integer getTurnNum() {
        return turnNum;
    }

    public void setTurnNum(Integer turnNum) {
        this.turnNum = turnNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}