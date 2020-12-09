package be.ipl.pfe.bizz.dto;

import be.ipl.pfe.dal.models.Citizen;
import be.ipl.pfe.dal.models.Place;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class VisitDto implements Serializable {

    @Id
    private Place place;

    @Id
    private Citizen citizen;

    @Id
    private String entrance_date;


}
