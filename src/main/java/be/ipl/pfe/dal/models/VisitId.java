package be.ipl.pfe.dal.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
public class VisitId implements Serializable {

    private Place place;
    private Citizen citizen;
    private Timestamp entrance_date;

}
