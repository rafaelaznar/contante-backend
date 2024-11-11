package net.ausiasmarch.contante.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tipocuenta")
public class TipoCuentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3, max = 255)
    private String descripcion;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private Long credito_o_debito;
    @NotNull
    @Size(min = 3, max = 255)
    private String comentarios;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private Long real_o_nominal;
  
    public TipoCuentaEntity() {
    }

    public TipoCuentaEntity(Long id, String descripcion, Long credito_o_debito, String comentarios, Long real_o_nominal) {
        this.id = id;
        this.descripcion = descripcion;
        this.credito_o_debito = credito_o_debito;
        this.comentarios = comentarios;
        this.real_o_nominal = real_o_nominal;
    }

    public TipoCuentaEntity(String descripcion, Long credito_o_debito, String comentarios, Long real_o_nominal) {
        this.descripcion = descripcion;
        this.credito_o_debito = credito_o_debito;
        this.comentarios = comentarios;
        this.real_o_nominal = real_o_nominal;
        
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

    public Long getCredito_o_debito() {
        return credito_o_debito;
    }

    public void setCredito_o_debito(Long credito_o_debito) {
        this.credito_o_debito = credito_o_debito;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Long getReal_o_nominal() {
        return real_o_nominal;
    }

    public void setReal_o_nominal(Long real_o_nominal) {
        this.real_o_nominal = real_o_nominal;
    }
}
