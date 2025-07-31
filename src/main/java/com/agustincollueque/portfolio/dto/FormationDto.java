package com.agustincollueque.portfolio.dto;

import com.agustincollueque.portfolio.model.Formacion;
import com.agustincollueque.portfolio.model.TipoFormacion;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Agustin Collueque
 */
@NoArgsConstructor
@Getter
@Setter
public class FormationDto {

    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String title;
    private String description;
    private TipoFormacion type;
    private String academy;
    private List<Long> technologies;

    public FormationDto(Formacion form) {
        this.id = form.getId();
        this.startDate = form.getStartDate();
        this.endDate = form.getEndDate();
        this.title = form.getTitle();
        this.description = form.getDescription();
        this.type = form.getType();
        this.academy = form.getAcademy();
        this.technologies = form.getTechnologies().stream()
                .map(f -> f.getId())
                .collect(Collectors.toList());
    }
}
