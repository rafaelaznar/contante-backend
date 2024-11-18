package net.ausiasmarch.contante.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "gruposubcuenta")
public class GrupoSubCuentaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private int orden;

    @ManyToOne (fetch = jakarta.persistence.FetchType.EAGER)
    @JoinColumn(name = "id_subcuenta")
    private SubCuentaEntity subcuenta;

    @ManyToOne (fetch = jakarta.persistence.FetchType.EAGER)
    @JoinColumn(name = "id_balance")
    private BalanceEntity balance;

    public GrupoSubCuentaEntity() {
    }

    public GrupoSubCuentaEntity(String descripcion) {
        this.descripcion = descripcion;
    }

    public GrupoSubCuentaEntity(Long id, String descripcion) {
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

    public BalanceEntity getId_balance() {
        return balance;
    }

    public void setId_balance(BalanceEntity id_balance) {
        this.balance = id_balance;
    }

    public SubCuentaEntity getId_subcuenta() {
        return subcuenta;
    }

    public void setId_subcuenta(SubCuentaEntity id_subcuenta) {
        this.subcuenta = id_subcuenta;
    }
    
    
}
