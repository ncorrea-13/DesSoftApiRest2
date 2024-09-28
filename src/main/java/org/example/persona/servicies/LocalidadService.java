package org.example.persona.servicies;

import java.util.List;

import org.example.persona.entities.Localidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LocalidadService extends BaseService<Localidad, Long> {
    List<Localidad> search(String filtro) throws Exception;

    Page<Localidad> search(String filtro, Pageable pageable) throws Exception;
}
