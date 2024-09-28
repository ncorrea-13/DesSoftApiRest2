package org.example.persona.repositories;

import java.util.List;

import org.example.persona.entities.Autor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends BaseRepository<Autor, Long> {

    List<Autor> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    Page<Autor> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    // boolean existById(int dni);

    @Query(value = "SELECT a FROM Autor a WHERE a.nombre LIKE %?1% OR a.apellido LIKE %?1%")
    List<Autor> search(String filtro);

    @Query(value = "SELECT a FROM Autor a WHERE a.nombre LIKE %?1% OR a.apellido LIKE %?1%")
    Page<Autor> search(String filtro, Pageable pageable);

    @Query(value = "SELECT * FROM Autor WHERE autor.nombre LIKE %?1% OR autor.apellido LIKE %?1%", nativeQuery = true)
    List<Autor> searchNativo(String filtro);

    @Query(value = "SELECT * FROM Autor WHERE autor.nombre LIKE %?1% OR autor.apellido LIKE %?1%", countQuery = "SELECT count(*) FROM Autor", nativeQuery = true)
    Page<Autor> searchNativo(String filtro, Pageable pageable);

}
