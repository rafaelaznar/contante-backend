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

@Entity
@Table(name = "gruposubcuenta")
public class GruposubcuentaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    @NotNull
    @Max(value = 128)
    private int orden;

    @ManyToOne (fetch = jakarta.persistence.FetchType.EAGER)
    @JoinColumn(name = "id_subcuenta")
    private SubcuentaEntity subcuenta;

    @ManyToOne (fetch = jakarta.persistence.FetchType.EAGER)
    @JoinColumn(name = "id_balance")
    private BalanceEntity balance;

    public GruposubcuentaEntity() {
    }

    public GruposubcuentaEntity(String descripcion) {
        this.descripcion = descripcion;
    }

    public GruposubcuentaEntity(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public BalanceEntity getBalance() {
        return balance;
    }

    public void setBalance(BalanceEntity balance) {
        this.balance = balance;
    }

    public SubcuentaEntity getSubcuenta() {
        return subcuenta;
    }

    public void setSubcuenta(SubcuentaEntity subcuenta) {
        this.subcuenta = subcuenta;
    }
    
    
}
