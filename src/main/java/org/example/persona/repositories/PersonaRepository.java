package org.example.persona.repositories;

import java.util.List;

import org.example.persona.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
    
    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);
    
    //boolean existById(int dni);

    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %?1% OR p.apellido LIKE %?1%")
    List<Persona> search(String filtro);

    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %?1% OR p.apellido LIKE %?1%")
    Page<Persona> search(String filtro, Pageable pageable);

    @Query(
        value = "SELECT * FROM Persona WHERE persona.nombre LIKE %?1% OR persona.apellido LIKE %?1%",
        nativeQuery = true
        )
    List<Persona> searchNativo(String filtro);

    @Query(
        value = "SELECT * FROM Persona WHERE persona.nombre LIKE %?1% OR persona.apellido LIKE %?1%",
        countQuery = "SELECT count(*) FROM Persona",
        nativeQuery = true
        )
    Page<Persona> searchNativo(String filtro, Pageable pageable);
}
