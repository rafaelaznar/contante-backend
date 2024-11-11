package net.ausiasmarch.contante.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;



@Entity
@Table(name = "cuenta")
public class CuentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull
    public String codigo;

    public String descripcion;

    public Long id_tipocuenta;

    public CuentaEntity(){

    }

    public CuentaEntity(Long id, String codigo, String descripcion, Long id_tipocuenta){
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.id_tipocuenta = id_tipocuenta;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getCodigo(){
        return codigo;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public String getDescripcion(){
        return codigo;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public Long getIdTipoCuenta(){
        return id_tipocuenta;
    }

    public void setIdTipoCuenta(Long id_tipocuenta){
        this.id_tipocuenta = id_tipocuenta;
    }
}


