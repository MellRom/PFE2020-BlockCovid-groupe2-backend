package be.ipl.pfe.bizz.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
public class CitizenDto implements Serializable {

    @Setter
    @Getter
    @Id
    @Nullable
    private int citizen_id;

    @Getter
    @Setter
    @Nullable
    private Timestamp sick_since;
}
