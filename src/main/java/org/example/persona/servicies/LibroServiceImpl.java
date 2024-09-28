package org.example.persona.servicies;

import java.util.List;

import org.example.persona.entities.Libro;
import org.example.persona.repositories.BaseRepository;
import org.example.persona.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LibroServiceImpl extends BaseServiceImpl<Libro, Long> implements LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public LibroServiceImpl(BaseRepository<Libro, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Libro> search(String filtro) throws Exception {
        try {
            // List<Persona> libros =
            // personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            // List<Persona> libros = personaRepository.search(filtro);
            List<Libro> libros = libroRepository.searchNativo(filtro);
            return libros;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Libro> search(String filtro, Pageable pageable) throws Exception {
        try {
            // Page<Persona> libros =
            // personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            // Page<Persona> libros = personaRepository.search(filtro);
            Page<Libro> libros = libroRepository.searchNativo(filtro, pageable);
            return libros;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
