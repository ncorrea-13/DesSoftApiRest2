package org.example.persona.repositories;

import java.util.List;

import org.example.persona.entities.Libro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends BaseRepository<Libro, Long> {
    // boolean existById(int dni);

    @Query(value = "SELECT l FROM Libro l WHERE l.titulo LIKE %?1%")
    List<Libro> search(String filtro);

    @Query(value = "SELECT l FROM Libro l WHERE l.titulo LIKE %?1%")
    Page<Libro> search(String filtro, Pageable pageable);

    @Query(value = "SELECT * FROM Libro WHERE libro.titulo LIKE %?1%", nativeQuery = true)
    List<Libro> searchNativo(String filtro);

    @Query(value = "SELECT * FROM Libro WHERE libro.titulo LIKE %?1%", countQuery = "SELECT count(*) FROM Libro", nativeQuery = true)
    Page<Libro> searchNativo(String filtro, Pageable pageable);
}
