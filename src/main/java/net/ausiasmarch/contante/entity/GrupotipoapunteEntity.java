package net.ausiasmarch.contante.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "grupotipoapunte")
public class GrupotipoapunteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = jakarta.persistence.FetchType.EAGER)
    @JoinColumn(name = "id_balance")
    private BalanceEntity balance;

    @ManyToOne(fetch = jakarta.persistence.FetchType.EAGER)
    @JoinColumn(name = "id_tipoapunte")
    private TipoapunteEntity tipoapunte;

    public GrupotipoapunteEntity() {
    }

    public GrupotipoapunteEntity(Long id,
            @NotNull Long id_balance,
            @NotNull Long id_tipoapunte) {
        this.id = id;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BalanceEntity getBalance() {
        return balance;
    }

    public void setBalance(BalanceEntity balance) {
        this.balance = balance;
    }

    public TipoapunteEntity getTipoapunte() {
        return tipoapunte;
    }

    public void setTipoapunte(TipoapunteEntity tipoapunte) {
        this.tipoapunte = tipoapunte;
    }

}
