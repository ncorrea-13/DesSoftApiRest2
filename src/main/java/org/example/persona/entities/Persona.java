package org.example.persona.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.hibernate.envers.Audited;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Audited
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Persona extends Base {

    private String nombre;
    private String apellido;
    private int dni;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Libro> libros = new HashSet<Libro>();

    @OneToOne(cascade = CascadeType.ALL)
    private Domicilio domicilio;
}
