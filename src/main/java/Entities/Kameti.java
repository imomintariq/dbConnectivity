package Entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "kameti", indexes = {
        @Index(name = "kametiHeadFK_idx", columnList = "kametiHead")
})
public class Kameti {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "kametiId", nullable = false)
    private Integer id;

    @Column(name = "kametiName", nullable = false, length = 45)
    private String kametiName;

    @Column(name = "startDate", nullable = false)
    private LocalDate startDate;

    @Column(name = "frequency", nullable = false, length = 45)
    private String frequency;

    @Column(name = "totalPayout", nullable = false)
    private Integer totalPayout;

    @Column(name = "kametiDuration", nullable = false)
    private Integer kametiDuration;

    @Column(name = "rule1", nullable = false, length = 45)
    private String rule1;

    @Column(name = "rule2", nullable = false, length = 45)
    private String rule2;

    @Column(name = "rule3", nullable = false, length = 45)
    private String rule3;

    @Column(name = "rule4", nullable = false, length = 45)
    private String rule4;

    @Column(name = "rule5", nullable = false, length = 45)
    private String rule5;

    @Column(name = "isPrivate", nullable = false, length = 45)
    private String isPrivate;

    @Column(name = "individualShare", nullable = false)
    private Integer individualShare;

    @Column(name = "totalMembers", nullable = false)
    private Integer totalMembers;

    @ManyToOne
    @JoinColumn(name = "kametiHead")
    private User kametiHead;

    public void addMember(User user){

        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(Member.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();


        Member member= new Member();

        member.setKametiId(this);
        member.setUsername(user);
        member.setTurnNumber(-1);
        member.setIsHead("false");
        member.setHasPaid("false");
        session.save(member);


        trans.commit();
    }

    public void generateTurns(){

    }

    public User getKametiHead() {
        return kametiHead;
    }

    public void setKametiHead(User kametiHead) {
        this.kametiHead = kametiHead;
    }

    public Integer getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(Integer totalMembers) {
        this.totalMembers = totalMembers;
    }

    public Integer getIndividualShare() {
        return individualShare;
    }

    public void setIndividualShare(Integer individualShare) {
        this.individualShare = individualShare;
    }

    public String getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(String isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getRule5() {
        return rule5;
    }

    public void setRule5(String rule5) {
        this.rule5 = rule5;
    }

    public String getRule4() {
        return rule4;
    }

    public void setRule4(String rule4) {
        this.rule4 = rule4;
    }

    public String getRule3() {
        return rule3;
    }

    public void setRule3(String rule3) {
        this.rule3 = rule3;
    }

    public String getRule2() {
        return rule2;
    }

    public void setRule2(String rule2) {
        this.rule2 = rule2;
    }

    public String getRule1() {
        return rule1;
    }

    public void setRule1(String rule1) {
        this.rule1 = rule1;
    }

    public Integer getKametiDuration() {
        return kametiDuration;
    }

    public void setKametiDuration(Integer kametiDuration) {
        this.kametiDuration = kametiDuration;
    }

    public Integer getTotalPayout() {
        return totalPayout;
    }

    public void setTotalPayout(Integer totalPayout) {
        this.totalPayout = totalPayout;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getKametiName() {
        return kametiName;
    }

    public void setKametiName(String kametiName) {
        this.kametiName = kametiName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}