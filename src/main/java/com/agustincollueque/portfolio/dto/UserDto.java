package com.agustincollueque.portfolio.dto;

import com.agustincollueque.portfolio.model.Formacion;
import com.agustincollueque.portfolio.model.Habilidad;
import com.agustincollueque.portfolio.model.Proyecto;
import com.agustincollueque.portfolio.model.Trabajo;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Agustin Collueque
 */
@NoArgsConstructor
@Getter @Setter
public class UserDto {
    private Long id;
    private String name;
    private String lastName;
    private String title;
    private String mainPhrase;
    private String secondaryPhrase;
    private int yearsXP;
    private String urlImg;
    private String urlCV;
    private int age;
    private String description;
    private String numberPhone;
    private String email;
    
    private List<Formacion> formations;
    private List<Trabajo> jobs;
    private List<Habilidad> skills;
    private List<Proyecto> projects;
}
