package net.ausiasmarch.contante.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cuenta")
public class CuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String codigo;

    private String descripcion;

    @ManyToOne(fetch = jakarta.persistence.FetchType.EAGER)
    @JoinColumn(name = "id_tipocuenta")
    private TipocuentaEntity tipocuenta;

    @OneToMany(mappedBy = "cuenta", fetch = FetchType.LAZY)
    private java.util.List<GrupocuentaEntity> grupocuentas;

    @OneToMany(mappedBy = "cuenta", fetch = FetchType.LAZY)
    private java.util.List<SubcuentaEntity> subcuentas;

    public CuentaEntity() {
    }

    public CuentaEntity(@NotNull String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipocuentaEntity getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(TipocuentaEntity tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    public int getGrupocuenta() {
        return grupocuentas.size();
    }

    public int getSubcuenta() {
        return subcuentas.size();
    }
}
