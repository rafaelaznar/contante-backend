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
@Table(name = "grupotipoasiento")
public class GrupotipoasientoEntity {

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
    @JoinColumn(name = "id_tipoasiento")
    private TipoasientoEntity tipoasiento;

    @ManyToOne(fetch = jakarta.persistence.FetchType.EAGER)
    @JoinColumn(name = "id_balance")
    private BalanceEntity balance;

    public GrupotipoasientoEntity() {
    }

    public GrupotipoasientoEntity(String titulo, String descripcion, int orden) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.orden = orden;
    }

    public GrupotipoasientoEntity(Long id, String titulo, String descripcion, int orden) {
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

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public TipoasientoEntity getTipoasiento() {
        return tipoasiento;
    }

    public void setTipoasiento(TipoasientoEntity tipoasiento) {
        this.tipoasiento = tipoasiento;
    }

    public BalanceEntity getBalance() {
        return balance;
    }

    public void setBalance(BalanceEntity balance) {
        this.balance = balance;
    }

}
