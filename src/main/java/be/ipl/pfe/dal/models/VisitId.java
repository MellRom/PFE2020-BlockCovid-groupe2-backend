package be.ipl.pfe.dal.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class VisitId implements Serializable {

    private int place_id;
    private Citizen citizen;
    private Timestamp entrance_date;

}
