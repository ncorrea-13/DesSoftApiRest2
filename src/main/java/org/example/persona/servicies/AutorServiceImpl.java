package org.example.persona.servicies;

import java.util.List;

import org.example.persona.entities.Autor;
import org.example.persona.repositories.AutorRepository;
import org.example.persona.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor, Long> implements AutorService {
    @Autowired
    private AutorRepository autoresRepository;

    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Autor> search(String filtro) throws Exception {
        try {
            // List<Persona> autores =
            // autoresRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            // List<Persona> autores = autoresRepository.search(filtro);
            List<Autor> autores = autoresRepository.searchNativo(filtro);
            return autores;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Autor> search(String filtro, Pageable pageable) throws Exception {
        try {
            // Page<Persona> autores =
            // autoresRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            // Page<Persona> autores = autoresRepository.search(filtro);
            Page<Autor> autores = autoresRepository.searchNativo(filtro, pageable);
            return autores;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
