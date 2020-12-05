package be.ipl.pfe.bizz.dto;


import be.ipl.pfe.dal.models.Place;
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
@Setter
@Getter
public class EstablishmentDto implements Serializable {


    @Id
    private int user_id;

    @Nullable
    private String address;

    private Set<PlaceDto> places;

}
