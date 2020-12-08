package be.ipl.pfe.dal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "citizen",schema = "projetpfe")
public class Citizen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int/*String*/ citizen_id;


    @Column(name = "sick_since")
    private Timestamp sick_since;

    @OneToMany(targetEntity = Visit.class, mappedBy = "citizen", fetch = FetchType.LAZY)
    private Set<Visit> visits;

    public Citizen(int citizen_id) {
        this.citizen_id = citizen_id;
    }
}