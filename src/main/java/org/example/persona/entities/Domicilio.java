package org.example.persona.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.hibernate.envers.Audited;

@Entity
@Table
@Audited
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Domicilio extends Base {

    private String calle;

    private int numero;

    @ManyToOne(optional = false)
    @JoinColumn(name = "localidad_id")
    private Localidad localidad;

    @OneToOne(mappedBy = "domicilio")
    private Persona persona;
}
