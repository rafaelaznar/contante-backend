package net.ausiasmarch.contante.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "periodo")
public class PeriodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int anyo;
    private String descripcion;
    private String comentarios;
    private boolean cerrado;







    
    public PeriodoEntity(Long id, int anyo, String descripcion, String comentarios, boolean cerrado) {
        this.id = id;
        this.anyo = anyo;
        this.descripcion = descripcion;
        this.comentarios = comentarios;
        this.cerrado = cerrado;
    }
    public PeriodoEntity(int anyo, String descripcion, String comentarios, boolean cerrado) {
        this.anyo = anyo;
        this.descripcion = descripcion;
        this.comentarios = comentarios;
        this.cerrado = cerrado;
    }
    public PeriodoEntity() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getAnyo() {
        return anyo;
    }
    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getComentarios() {
        return comentarios;
    }
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    public boolean isCerrado() {
        return cerrado;
    }
    public void setCerrado(boolean cerrado) {
        this.cerrado = cerrado;
    }
   

    

}
