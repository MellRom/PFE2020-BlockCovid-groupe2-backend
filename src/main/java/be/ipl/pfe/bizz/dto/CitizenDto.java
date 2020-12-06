package be.ipl.pfe.bizz.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.Id;
import java.io.Serializable;
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

    @Nullable
    @JsonIgnore
    private Set<VisitDto> visitsDto;
}
