package com.agustincollueque.portfolio.dto;

import com.agustincollueque.portfolio.model.Proyecto;
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
public class ProjectDto {

    private Long id;
    private String title;
    private String description;
    private String link;
    private String urlImg;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Long> technologies;

    public ProjectDto(Proyecto proj) {
        this.id = proj.getId();
        this.startDate = proj.getStartDate();
        this.endDate = proj.getEndDate();
        this.title = proj.getTitle();
        this.description = proj.getDescription();
        this.link = proj.getLink();
        this.urlImg = proj.getUrlImg();
        this.technologies = proj.getTechnologies().stream()
                .map(f -> f.getId())
                .collect(Collectors.toList());
    }
}
