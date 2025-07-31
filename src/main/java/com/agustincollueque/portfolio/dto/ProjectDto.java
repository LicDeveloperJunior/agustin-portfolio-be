package com.agustincollueque.portfolio.dto;

import java.time.LocalDate;
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
public class ProjectDto {
    private Long id;
    private String title;
    private String description;
    private String link;
    private String urlImg;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Long> technologies;
}
