package org.example.persona.servicies;

import java.util.List;

import org.example.persona.entities.Libro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LibroService extends BaseService<Libro, Long> {
    List<Libro> search(String filtro) throws Exception;

    Page<Libro> search(String filtro, Pageable pageable) throws Exception;
}
