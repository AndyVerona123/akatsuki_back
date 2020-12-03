package co.edu.udea.basededatos.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="valor_total", nullable=false)
    private BigDecimal valor_total;

    @Column(name="cantidad", nullable = false)
    private Integer cantidad;

    @Column(name="fecha_venta", nullable=false)
    private LocalDate fecha_venta;

    @Column(name="estado", nullable=false)
    private Boolean estado;

    @Column(name="fk_cliente", nullable=false)
    private Long fk_cliente;

    @Column(name="fk_producto", nullable=false)
    private Long fk_producto;

    // relationships

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_cliente", insertable = false, updatable = false)
    private Usuario cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_producto", insertable = false, updatable = false)
    private Producto producto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor_total() {
        return valor_total;
    }

    public void setValor_total(BigDecimal valor_total) {
        this.valor_total = valor_total;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(LocalDate fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Long getFk_cliente() {
        return fk_cliente;
    }

    public void setFk_cliente(Long fk_cliente) {
        this.fk_cliente = fk_cliente;
    }

    public Long getFk_producto() {
        return fk_producto;
    }

    public void setFk_producto(Long fk_producto) {
        this.fk_producto = fk_producto;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
