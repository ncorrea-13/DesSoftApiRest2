package org.example.persona.servicies;

import java.util.List;

import org.example.persona.entities.Domicilio;
import org.example.persona.repositories.BaseRepository;
import org.example.persona.repositories.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, Long> implements DomicilioService {

    @Autowired
    private DomicilioRepository domicilioRepository;

    public DomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Domicilio> search(String filtro) throws Exception {
        try {
            // List<Persona> domicilios =
            // personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            // List<Persona> domicilios = personaRepository.search(filtro);
            List<Domicilio> domicilios = domicilioRepository.searchNativo(filtro);
            return domicilios;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Domicilio> search(String filtro, Pageable pageable) throws Exception {
        try {
            // Page<Persona> domicilios =
            // domicilioRepository.findByNombreContainingOrApellidoContaining(filtro,
            // filtro);
            // Page<Persona> domicilios = domicilioRepository.search(filtro);
            Page<Domicilio> domicilios = domicilioRepository.searchNativo(filtro, pageable);
            return domicilios;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
