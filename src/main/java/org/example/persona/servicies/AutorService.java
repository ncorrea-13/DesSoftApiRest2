package org.example.persona.servicies;

import java.util.List;

import org.example.persona.entities.Autor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AutorService extends BaseService<Autor, Long>{
        List<Autor> search(String filtro) throws Exception;

        Page<Autor> search(String filtro, Pageable pageable) throws Exception;
}
