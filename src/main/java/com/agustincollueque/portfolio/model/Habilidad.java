package com.agustincollueque.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Habilidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String urlLogo;
    private String description;
    private boolean isLearning;
    @ElementCollection(targetClass = SkillType.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "skill_skilltypes", joinColumns = @JoinColumn(name = "skill_id"))
    @Column(name = "skill_type")
    private List<SkillType> skills = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "technologies")
    private Set<Proyecto> projects;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "technologies")
    private Set<Formacion> formations;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "technologies")
    private Set<Trabajo> jobs;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario user;
}
