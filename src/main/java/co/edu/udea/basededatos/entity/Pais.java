package co.edu.udea.basededatos.entity;

import javax.persistence.*;

@Entity
@Table(name = "pais")
public class Pais {
//holi
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo_llamada")
    private String codigoLlamada;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nombre_corto")
    private String nombreCorto;

    @Column(name = "habilitado")
    private Boolean habilitado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoLlamada() {
        return codigoLlamada;
    }

    public void setCodigoLlamada(String codigoLlamada) {
        this.codigoLlamada = codigoLlamada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }
}
