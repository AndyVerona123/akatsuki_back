package co.edu.udea.basededatos.entity;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name= "transporte")
public class Transporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name="placa", nullable=false, length= 10)
    private String placa;

    @Column(name="fk_tipo_transporte", nullable=false)
    private Long fk_tipotransporte;

    //relationships

    @ManyToOne
    @JoinColumn(name="fk_tipo_transporte", insertable = false, updatable = false)
    private TipoTransporte tipoTransporte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Long getFk_tipotransporte() {
        return fk_tipotransporte;
    }

    public void setFk_tipotransporte(Long fk_tipotransporte) {
        this.fk_tipotransporte = fk_tipotransporte;
    }

    public TipoTransporte getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(TipoTransporte tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }
}
