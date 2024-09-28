package org.example.persona.repositories;

import java.util.List;

import org.example.persona.entities.Localidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadRepository extends BaseRepository<Localidad, Long> {
    // boolean existById(int dni);

    @Query(value = "SELECT l FROM Localidad l WHERE l.denominacion LIKE %?1%")
    List<Localidad> search(String filtro);

    @Query(value = "SELECT l FROM Localidad l WHERE l.denominacion LIKE %?1%")
    Page<Localidad> search(String filtro, Pageable pageable);

    @Query(value = "SELECT * FROM Localidad WHERE localidad.denominacion LIKE %?1%", nativeQuery = true)
    List<Localidad> searchNativo(String filtro);

    @Query(value = "SELECT * FROM Localidad WHERE localidad.denominacion LIKE %?1%", countQuery = "SELECT count(*) FROM Localidad", nativeQuery = true)
    Page<Localidad> searchNativo(String filtro, Pageable pageable);
}
