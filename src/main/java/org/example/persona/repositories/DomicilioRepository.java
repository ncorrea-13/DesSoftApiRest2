package org.example.persona.repositories;

import java.util.List;

import org.example.persona.entities.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio, Long> {

    // boolean existById(int dni);

    @Query(value = "SELECT d FROM Domicilio d WHERE d.calle LIKE %?1%")
    List<Domicilio> search(String filtro);

    @Query(value = "SELECT d FROM Domicilio d WHERE d.calle LIKE %?1%")
    Page<Domicilio> search(String filtro, Pageable pageable);

    @Query(value = "SELECT * FROM Domicilio WHERE domicilio.calle LIKE %?1%", nativeQuery = true)
    List<Domicilio> searchNativo(String filtro);

    @Query(value = "SELECT * FROM Domicilio WHERE domicilio.calle LIKE %?1%", countQuery = "SELECT count(*) FROM Domicilio", nativeQuery = true)
    Page<Domicilio> searchNativo(String filtro, Pageable pageable);
}
