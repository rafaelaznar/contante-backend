package net.ausiasmarch.contante.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tipoasiento")
public class TipoasientoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 255)
    private String descripcion;

    @OneToMany(mappedBy = "tipoasiento", fetch = FetchType.LAZY)
    private java.util.List<AsientoEntity> asientos;

    @OneToMany(mappedBy = "tipoasiento", fetch = FetchType.LAZY)
    private java.util.List<GrupotipoasientoEntity> grupotipoasientos;

    public TipoasientoEntity() {
    }

    public TipoasientoEntity(@NotNull @Size(min = 3, max = 255) String descripcion) {
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

    public int getAsientos() {
        return asientos.size();
    }

    public int getGrupotipoasientos() {
        return grupotipoasientos.size();
    }

}
