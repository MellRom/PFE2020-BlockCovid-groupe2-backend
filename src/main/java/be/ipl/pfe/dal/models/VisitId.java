package be.ipl.pfe.dal.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class VisitId implements Serializable {

    private Place place;
    private Citizen citizen;
    private Timestamp entrance_date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitId visitId = (VisitId) o;
        return Objects.equals(place, visitId.place) &&
                Objects.equals(citizen, visitId.citizen) &&
                Objects.equals(entrance_date, visitId.entrance_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(place, citizen, entrance_date);
    }
}
