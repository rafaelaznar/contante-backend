package net.ausiasmarch.contante.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "grupocuenta")
public class GrupoCuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull
    public String titulo;

    @NotNull
    public String descripcion;

    @NotNull
    public int orden;

    @NotNull
    public Long id_cuenta;

    @NotNull
    public Long id_balance;

    public GrupoCuentaEntity() {
    }

    public GrupoCuentaEntity(Long id, @NotNull String titulo, @NotNull String descripcion, @NotNull int orden,
            @NotNull Long id_cuenta, @NotNull Long id_balance) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.orden = orden;
        this.id_cuenta = id_cuenta;
        this.id_balance = id_balance;
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

    public Long getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(Long id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public Long getId_balance() {
        return id_balance;
    }

    public void setId_balance(Long id_balance) {
        this.id_balance = id_balance;
    }

}
