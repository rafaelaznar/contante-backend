package net.ausiasmarch.contante.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "grupotipoapunte")
public class GrupoTipoApunteEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;


   @NotNull
   @Size(min = 3, max = 255)
   private String titulo;


   @NotNull
   @Size(min = 3, max = 255)
   private String descripcion;


   @NotNull
   @Max(value = 128)
   private Long orden;


   @NotNull
   private Long id_balance;


   @NotNull
   private Long id_tipoapunte;


public GrupoTipoApunteEntity() {
}

@ManyToOne(fetch = jakarta.persistence.FetchType.EAGER)
@JoinColumn(name = "id_balance")
private GrupoTipoApunteEntity balance;

@ManyToOne(fetch = jakarta.persistence.FetchType.EAGER)
@JoinColumn(name = "id_tipoapunte")
private GrupoTipoApunteEntity tipoapunte;


public GrupoTipoApunteEntity(Long id, @NotNull @Size(min = 3, max = 255) String titulo,
        @NotNull @Size(min = 3, max = 255) String descripcion, @NotNull @Max(128) Long orden, @NotNull Long id_balance,
        @NotNull Long id_tipoapunte) {
    this.id = id;
    this.titulo = titulo;
    this.descripcion = descripcion;
    this.orden = orden;
    this.id_balance = id_balance;
    this.id_tipoapunte = id_tipoapunte;
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


public Long getOrden() {
    return orden;
}


public void setOrden(Long arrorden) {
    this.orden = arrorden;
}


public Long getId_balance() {
    return id_balance;
}


public void setId_balance(Long id_balance) {
    this.id_balance = id_balance;
}


public Long getId_tipoapunte() {
    return id_tipoapunte;
}


public void setId_tipoapunte(Long id_tipoapunte) {
    this.id_tipoapunte = id_tipoapunte;
}


public GrupoTipoApunteEntity getBalance() {
    return balance;
}


public void setBalance(GrupoTipoApunteEntity balance) {
    this.balance = balance;
}


public GrupoTipoApunteEntity getTipoapunte() {
    return tipoapunte;
}


public void setTipoapunte(GrupoTipoApunteEntity tipoapunte) {
    this.tipoapunte = tipoapunte;
}



}
