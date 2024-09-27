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
public class Autor extends Base {

    private String nombre;
    private String apellido;

    @Column(length = 1500)
    private String biografia;

    @ManyToMany(mappedBy = "autores", cascade = CascadeType.ALL)
    private Set<Libro> libros = new HashSet<Libro>();

}
