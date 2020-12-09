package be.ipl.pfe.dal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "citizen",schema = "projetpfe")
public class Citizen implements Serializable {

    @Id
    private String citizen_id;

    @Column(name = "sick_since")
    private Timestamp sick_since;

    @OneToMany(targetEntity = Visit.class, mappedBy = "citizen", fetch = FetchType.LAZY)
    private Set<Visit> visits;

    public Citizen(String citizen_id) {
        this.citizen_id = citizen_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citizen citizen = (Citizen) o;
        return citizen_id == citizen.citizen_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(citizen_id);
    }
}