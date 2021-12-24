package Entities;

import javax.persistence.*;

@Entity
@Table(name = "admin", indexes = {
        @Index(name = "usernamefk_idx", columnList = "username")
})
public class Admin extends User{
    @Id
    @Column(name = "adminID", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "username", nullable = false)
    private User username;

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public Integer getAdminId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}