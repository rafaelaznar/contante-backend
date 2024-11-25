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
@Table(name = "tipoapunte")
public class TipoapunteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 255)
    private String descripcion;

    @NotNull
    @Size(min = 3, max = 255)
    private String comentarios;

    @OneToMany(mappedBy = "tipoapunte",fetch = FetchType.LAZY)
    private java.util.List<ApunteEntity> apuntes;

    @OneToMany(mappedBy = "tipoapunte",fetch = FetchType.LAZY)
    private java.util.List<GrupotipoapunteEntity> grupotipoapuntes;
    
    public TipoapunteEntity() {
    }

    public TipoapunteEntity(Long id, @NotNull @Size(min = 3, max = 255) String descripcion,
            @NotNull @Size(min = 3, max = 255) String comentarios) {
        this.id = id;
        this.descripcion = descripcion;
        this.comentarios = comentarios;
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

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getApuntes() {
        return apuntes.size();
    }

    public int getGrupotipocuentas() {
        return grupotipoapuntes.size();
    }

    
}
