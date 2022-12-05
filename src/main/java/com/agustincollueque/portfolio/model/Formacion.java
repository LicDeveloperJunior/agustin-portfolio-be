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
public class Formacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idForm;
    
    private String tiempo;
    private String titulo;
    private String enlace;
    private String imagen;

    public Formacion(Long id, String tiempo, String empresa, String descripcion, String enlace, String imagen) {
        this.idForm = id;
        this.tiempo = tiempo;
        this.titulo = descripcion;
        this.enlace = enlace;
        this.imagen = imagen;
    }
}
