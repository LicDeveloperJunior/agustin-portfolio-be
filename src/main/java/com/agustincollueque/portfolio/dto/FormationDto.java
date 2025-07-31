package com.agustincollueque.portfolio.dto;

import com.agustincollueque.portfolio.model.TipoFormacion;
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
public class FormationDto {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String title;
    private String description;
    private TipoFormacion type;
    private String academy;
    private List<Long> technologies;
}
