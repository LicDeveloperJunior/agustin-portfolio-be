package com.agustincollueque.portfolio.dto;

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
    
    private List<FormationDto> formations;
    private List<JobDto> jobs;
    private List<SkillDto> skills;
    private List<ProjectDto> projects;
}
