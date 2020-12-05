package be.ipl.pfe.bizz.dto;


import be.ipl.pfe.dal.models.Visit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CitizenDto implements Serializable {

    @Id
    private int citizen_id;

    @Nullable
    private Timestamp sick_since;

    private Set<VisitDto> visits;
}
