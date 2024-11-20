package net.ausiasmarch.contante.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tipoapunte")
public class TipoApunteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 255)
    private String descripcion;

    @NotNull
    @Size(min = 3, max = 255)
    private String comentarios;

    @OneToMany(fetch = jakarta.persistence.FetchType.EAGER)
    @JoinColumn(name = "id_apunte")
    private ApunteEntity apunte;

    @OneToMany(fetch = jakarta.persistence.FetchType.EAGER)
    @JoinColumn(name = "id_grupotipoapunte")
    private GrupoTipoApunteEntity grupotipoapunte;


    @OneToMany(mappedBy = "tipoapunte",fetch = FetchType.LAZY)
    private java.util.List<ApunteEntity> apuntes;

    @OneToMany(mappedBy = "tipoapunte",fetch = FetchType.LAZY)
    private java.util.List<ApunteEntity> grupotipoapuntes;
    
    public TipoApunteEntity() {
    }

    public TipoApunteEntity(Long id, @NotNull @Size(min = 3, max = 255) String descripcion,
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

    public ApunteEntity getApunte() {
        return apunte;
    }

    public void setApunte(ApunteEntity apunte) {
        this.apunte = apunte;
    }

    public GrupoTipoApunteEntity getGrupotipoapunte() {
        return grupotipoapunte;
    }

    public void setGrupotipoapunte(GrupoTipoApunteEntity grupotipoapunte) {
        this.grupotipoapunte = grupotipoapunte;
    }

    
}
