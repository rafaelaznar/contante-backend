package net.ausiasmarch.contante.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "periodo")
public class PeriodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Digits(integer = 4, fraction = 0)
    private int anyo;

    @NotNull
    @Size(min = 3, max = 255)
    private String descripcion;

    @NotNull
    @Size(min = 3, max = 255)
    private String comentarios;

    @NotNull
    private boolean cerrado;


    @OneToMany(mappedBy = "periodo",fetch = FetchType.LAZY)
    private java.util.List<AsientoEntity> asientos; 

    public PeriodoEntity(){}

    public PeriodoEntity(@NotNull @Digits(integer = 4, fraction = 0) int anyo,
            @NotNull @Size(min = 3, max = 255) String descripcion,
            @NotNull @Size(min = 3, max = 255) String comentarios, @NotNull boolean cerrado) {
        this.anyo = anyo;
        this.descripcion = descripcion;
        this.comentarios = comentarios;
        this.cerrado = cerrado;
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

    public int getAsientos() {
        return asientos.size();
    }
 

    
    
}
