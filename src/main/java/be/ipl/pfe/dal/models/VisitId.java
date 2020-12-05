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
    private int citizen_id;
    private Timestamp entrance_date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitId visitId = (VisitId) o;
        return Objects.equals(place_id, visitId.place_id) &&
                Objects.equals(citizen_id, visitId.citizen_id) &&
                Objects.equals(entrance_date, visitId.entrance_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(place_id, citizen_id, entrance_date);
    }
}
