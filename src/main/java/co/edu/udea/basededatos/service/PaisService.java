package co.edu.udea.basededatos.service;

import co.edu.udea.basededatos.entity.Pais;
import co.edu.udea.basededatos.repository.PaisRepository;
import org.springframework.stereotype.Service;

@Service
public class PaisService {

    private final PaisRepository paisRepository;

    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public Pais guardarPais(Pais pais) {
        return paisRepository.save(pais);
    }
}
