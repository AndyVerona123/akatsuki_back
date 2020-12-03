package co.edu.udea.basededatos.entity;

import javax.persistence.*;

@Entity
@Table
public class EnvioPorCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="fk_envio", nullable=false)
    private Long fk_envio;

    @Column(name="fk_venta", nullable=false)
    private Long fk_venta;

    @Column(name="estado", nullable=false)
    private Boolean estado;

    // relationships

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_envio", insertable = false, updatable = false)
    private Envio envio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_venta", insertable = false, updatable = false)
    private Compra compra;


}
