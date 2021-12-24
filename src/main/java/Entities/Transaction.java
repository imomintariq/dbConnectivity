package Entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transaction", indexes = {
        @Index(name = "receiverAccountFK_idx", columnList = "receiverAccount"),
        @Index(name = "senderAccountFK_idx", columnList = "senderAccount")
})
public class Transaction {
    @Id
    @Column(name = "idtransaction", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "senderAccount")
    private User senderAccount;

    @ManyToOne
    @JoinColumn(name = "receiverAccount")
    private User receiverAccount;

    @Column(name = "dateOfTransaction")
    private LocalDate dateOfTransaction;

    @Column(name = "amount")
    private Double amount;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(LocalDate dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public User getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(User receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public User getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(User senderAccount) {
        this.senderAccount = senderAccount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}