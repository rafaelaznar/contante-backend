package net.ausiasmarch.contante.entity;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "subcuenta")
public class SubCuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private int codigo;
    @NotNull
    @Size(min = 3, max = 255)
    private String descripcion;
    @NotNull
    private BigDecimal id_cuenta;
    @NotNull
    private String momentstamp;

    public SubCuentaEntity() {
    }

    public SubCuentaEntity(long id, int codigo, String descripcion,BigDecimal id_cuenta, String momentstamp) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.id_cuenta = id_cuenta;
        this.momentstamp = momentstamp;
    }

    public SubCuentaEntity( int codigo, String descripcion, BigDecimal id_cuenta, String momentstamp) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.id_cuenta = id_cuenta;
        this.momentstamp = momentstamp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(BigDecimal id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getMomentstamp() {
        return momentstamp;
    }

    public void setMomentstamp(String momentstamp) {
        this.momentstamp = momentstamp;
    }

}
