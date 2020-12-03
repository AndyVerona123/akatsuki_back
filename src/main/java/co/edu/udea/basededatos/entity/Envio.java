package co.edu.udea.basededatos.entity;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fk_transporte", nullable = false)
    private Long fktransporte;

    @Column(name = "fk_Ciudad_Destino", nullable = false)
    private Long fk_ciudadDestino;

    @Column(name = "fk_Ciudad_Origen", nullable = false)
    private Long fk_ciudadOrigen;


    // relationships

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_transporte", insertable = false, updatable = false)
    private Transporte transporte;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_Ciudad_Destino", insertable = false, updatable = false)
    private Ciudad ciudadD;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_Ciudad_Origen", insertable = false, updatable = false)
    private Ciudad ciudadO;
}
