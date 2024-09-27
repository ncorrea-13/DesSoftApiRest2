package org.example.persona.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.hibernate.envers.Audited;

import java.util.Set;
import java.util.HashSet;

@Entity
@Table
@Audited
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Libro extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private int fecha;
    private String genero;
    private int paginas;
    private String autor;


    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "libro_autor", joinColumns = @JoinColumn(name = "id_libro"), inverseJoinColumns = @JoinColumn(name = "id_autor"))
    private Set<Autor> autores = new HashSet<Autor>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "persona_id")
    private Persona persona;
}
