package co.edu.udea.basededatos.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="insumo")
public class Insumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="costo", nullable=false)
    private BigDecimal costo;

    @Column(name="nombre", nullable= false, length= 100)
    private String nombre;

    @Column(name="observacion", length = 200)
    private String observacion;

    @Column(name="fk_producto", nullable=false)
    private Long fk_producto;

    // relationships

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_producto", insertable = false, updatable = false)
    private Producto producto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Long getFk_producto() {
        return fk_producto;
    }

    public void setFk_producto(Long fk_producto) {
        this.fk_producto = fk_producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
