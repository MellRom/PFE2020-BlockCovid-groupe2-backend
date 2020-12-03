package be.ipl.pfe.dal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(VisitId.class)
@Table(name = "visit",schema = "projetpfe")
public class Visit implements Serializable{

        @Getter
        @Setter
        @Id
        @Column(name = "place_id")
        private int place_id;

        @Getter
        @Setter
        @Column(name = "citizen_id")
        private int citizen_id;

        @Getter
        @Setter
        @Column(name = "entrance_date")
        private Timestamp entrance_date;

}
