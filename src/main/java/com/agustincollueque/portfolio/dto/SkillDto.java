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
public class SkillDto {
    private Long id;
    private String name;
    private String urlLogo;
    private boolean isLearning;
    private List<String> skills;
}
