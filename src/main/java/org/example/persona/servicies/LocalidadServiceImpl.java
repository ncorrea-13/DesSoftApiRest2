package org.example.persona.servicies;

import java.util.List;

import org.example.persona.entities.Localidad;
import org.example.persona.repositories.BaseRepository;
import org.example.persona.repositories.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long> implements LocalidadService {

    @Autowired
    private LocalidadRepository localidadRepository;

    public LocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Localidad> search(String filtro) throws Exception {
        try {
            // List<Persona> localidades =
            // personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            // List<Persona> localidades = personaRepository.search(filtro);
            List<Localidad> localidades = localidadRepository.searchNativo(filtro);
            return localidades;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Localidad> search(String filtro, Pageable pageable) throws Exception {
        try {
            // Page<Persona> localidades =
            // personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            // Page<Persona> localidades = personaRepository.search(filtro);
            Page<Localidad> localidades = localidadRepository.searchNativo(filtro, pageable);
            return localidades;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
