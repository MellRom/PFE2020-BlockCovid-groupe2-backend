package be.ipl.pfe.bizz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CitizenDto implements Serializable {

    @Id
    private String citizen_id;

    @Nullable
    private String sick_since;

    @Nullable
    private String id_qrcode;

    @Nullable
    private Set<VisitDto> visits;
}
