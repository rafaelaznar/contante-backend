package net.ausiasmarch.contante.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tipocuenta")
public class GrupotipocuentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3, max = 255)
    private String titulo;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private String descripcion;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private Long orden;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private Long id_tipocuenta;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private Long id_balance;

    @ManyToOne(fetch = jakarta.persistence.FetchType.EAGER)
    @JoinColumn(name = "id_tipocuenta")
    private TipocuentaEntity tipoCuenta;

    @ManyToOne(fetch = jakarta.persistence.FetchType.EAGER)
    @JoinColumn(name = "id_balance")
    private BalanceEntity balance;
  
    public GrupotipocuentaEntity() {
    }

    public GrupotipocuentaEntity(Long id, String titulo, String descripcion, Long orden,Long idTipoCuenta,Long idBalance ) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.orden = orden;
        this.id_tipocuenta = idTipoCuenta;
        this.id_balance = idBalance;
    }

    public GrupotipocuentaEntity(String titulo, String descripcion, Long idTipoCuenta, Long idBalance) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.id_tipocuenta = idTipoCuenta;
        this.id_balance = idBalance;
        
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

    public void setOrden(Long orden) {
        this.orden = orden;
    }

    public TipocuentaEntity getTipocuenta() {
        return tipoCuenta;
    }

    public void setTipocuenta(TipocuentaEntity tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public BalanceEntity getBalance() {
        return balance;
    }

    public void setBalance(BalanceEntity balance) {
        this.balance = balance;
    }
}
