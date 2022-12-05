package com.agustincollueque.portfolio.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Usuario {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO )
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String descripcion;
    private String domicilio;
    private String estado;
    private String telefono;
    private String email;
    private String foto;
    
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "idForm")
    private List<Formacion> listaFormacion;
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "idHab")
    private List<Habilidad> listaHabilidad;
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "idTrab")
    private List<Trabajo> listaTrabajo;

    public Usuario(Long id, String nombre, String apellido, String fechaNacimiento, String descripcion, String domicilio, String estado, String telefono, String email, String contrasenia, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.descripcion = descripcion;
        this.domicilio = domicilio;
        this.estado = estado;
        this.telefono = telefono;
        this.email = email;
        this.foto = foto;
    }
}
