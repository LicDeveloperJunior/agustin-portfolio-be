package com.agustincollueque.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Trabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTrab;
    
    private String nombre;
    private String descripcion;
    private String imagen;

    public Trabajo(Long id, String nombre, String descripcion, String imagen) {
        this.idTrab = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }
}