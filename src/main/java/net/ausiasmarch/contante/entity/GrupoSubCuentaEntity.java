package net.ausiasmarch.contante.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
    private long id_balance;
    private long id_subcuenta;

    @OneToMany(mappedBy = "gruposubcuenta",fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subcuenta")
    private java.util.List<SubCuentaEntity> subcuentas;

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

    public int getSubcuentas() {
        return subcuentas.size();
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

    public long getId_balance() {
        return id_balance;
    }

    public void setId_balance(long id_balance) {
        this.id_balance = id_balance;
    }

    public long getId_subcuenta() {
        return id_subcuenta;
    }

    public void setId_subcuenta(long id_subcuenta) {
        this.id_subcuenta = id_subcuenta;
    }

    public void setSubcuentas(java.util.List<SubCuentaEntity> subcuentas) {
        this.subcuentas = subcuentas;
    }

    
}
