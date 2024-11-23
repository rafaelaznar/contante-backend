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
@Table(name = "balance")
public class BalanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3, max = 255)
    private String titulo;
    @NotNull
    @Size(min = 3, max = 255)
    private String descripcion;

    @OneToMany(mappedBy = "balance", fetch = FetchType.LAZY)
    private java.util.List<GrupotipoasientoEntity> grupoasientos;

    @OneToMany(mappedBy = "balance", fetch = FetchType.LAZY)
    private java.util.List<GruposubcuentaEntity> gruposubcuentas;

    @OneToMany(mappedBy = "balance", fetch = FetchType.LAZY)
    private java.util.List<GrupotipocuentaEntity> grupotipocuentas;

    @OneToMany(mappedBy = "balance", fetch = FetchType.LAZY)
    private java.util.List<GrupocuentaEntity> grupocuentas;

    @OneToMany(mappedBy = "balance", fetch = FetchType.LAZY)
    private java.util.List<GrupotipoapunteEntity> grupotipoapuntes;

    public BalanceEntity() {
    }

    public BalanceEntity(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
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

    public int getGrupoTipoCuentas() {
        return grupotipocuentas.size();
    }

    public int getGrupoasientos() {
        return grupoasientos.size();
    }

    public int getSubcuentas() {
        return gruposubcuentas.size();
    }

    public int getGrupocuentas() {
        return grupocuentas.size();
    }

    public int getGrupotipocuentas() {
        return grupotipocuentas.size();
    }

    public int getGrupotipoapuntes() {
        return grupotipoapuntes.size();
    }

}
