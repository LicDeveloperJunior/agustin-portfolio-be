package com.agustincollueque.portfolio.dto;

import com.agustincollueque.portfolio.model.Trabajo;
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
public class JobDto {

    private Long id;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String urlImg;
    private List<Long> technologies;

    public JobDto(Trabajo job) {
        this.id = job.getId();
        this.startDate = job.getStartDate();
        this.endDate = job.getEndDate();
        this.title = job.getTitle();
        this.description = job.getDescription();
        this.urlImg = job.getUrlImg();
        this.technologies = job.getTechnologies().stream()
                .map(f -> f.getId())
                .collect(Collectors.toList());
    }
}
