package com.agustincollueque.portfolio.dto;

import com.agustincollueque.portfolio.model.Habilidad;
import com.agustincollueque.portfolio.model.SkillType;
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
public class SkillDto {
    private Long id;
    private String name;
    private String urlLogo;
    private boolean isLearning;
    private SkillType type;
    private List<String> skills;
    
    public SkillDto(Habilidad skill) {
        this.id = skill.getId();
        this.name = skill.getName();
        this.isLearning = skill.isLearning();
        this.type = skill.getType();
        this.urlLogo = skill.getUrlLogo();
        this.skills = skill.getSkills();
    }
}
