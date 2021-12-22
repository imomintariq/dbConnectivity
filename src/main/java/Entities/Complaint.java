package Entities;

import javax.persistence.*;

@Entity
@Table(name = "complaint", indexes = {
        @Index(name = "kametiIdFK_idx", columnList = "kametiId"),
        @Index(name = "offenderFK_idx", columnList = "offender"),
        @Index(name = "reporterFK_idx", columnList = "reporter")
})
public class Complaint {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "idnew_table", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "offender", nullable = false)
    private User offender;

    @ManyToOne(optional = false)
    @JoinColumn(name = "reporter", nullable = false)
    private User reporter;

    @Column(name = "description", nullable = false, length = 250)
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "kametiId", nullable = false)
    private Kameti kametiId;

    public Kameti getKametiId() {
        return kametiId;
    }

    public void setKametiId(Kameti kametiId) {
        this.kametiId = kametiId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public User getOffender() {
        return offender;
    }

    public void setOffender(User offender) {
        this.offender = offender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}