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
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idHab;
    
    private String nombre;
    private String porcentaje;
    private String logo;

    public Habilidad(Long id, String nombre, String porcentaje, String logo) {
        this.idHab = id;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.logo = logo;
    }
}
