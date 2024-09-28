package org.example.persona.servicies;

import java.util.List;

import org.example.persona.entities.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DomicilioService extends BaseService<Domicilio, Long> {
    List<Domicilio> search(String filtro) throws Exception;

    Page<Domicilio> search(String filtro, Pageable pageable) throws Exception;
}
