package net.ausiasmarch.contante.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "grupotipoapunte")
public class GrupotipoapunteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 255)
    private String titulo;

    @NotNull
    @Size(min = 3, max = 255)
    private String descripcion;

    @NotNull
    @Max(value = 128)
    private int orden;

    @ManyToOne(fetch = jakarta.persistence.FetchType.EAGER)
    @JoinColumn(name = "id_balance")
    private BalanceEntity balance;

    @ManyToOne(fetch = jakarta.persistence.FetchType.EAGER)
    @JoinColumn(name = "id_tipoapunte")
    private TipoapunteEntity tipoapunte;

    public GrupotipoapunteEntity() {
    }

    public GrupotipoapunteEntity(Long id, @NotNull @Size(min = 3, max = 255) String titulo,
            @NotNull @Size(min = 3, max = 255) String descripcion, @NotNull @Max(128) int orden,
            @NotNull Long id_balance,
            @NotNull Long id_tipoapunte) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.orden = orden;
   
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int arrorden) {
        this.orden = arrorden;
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
