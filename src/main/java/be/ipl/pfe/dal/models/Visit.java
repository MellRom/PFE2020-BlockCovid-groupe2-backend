package be.ipl.pfe.dal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@IdClass(VisitId.class)
@Table(name = "visit",schema = "projetpfe")
public class Visit implements Serializable{

        @Id
        @JoinColumn(name = "citizen_id")
        @ManyToOne(fetch = FetchType.LAZY)
        @Fetch(FetchMode.JOIN)
        private Citizen citizen;

        @Id
        @JoinColumn(name = "place_id")
        @ManyToOne(fetch = FetchType.LAZY)
        private Place place;

        @Id
        @Column(name = "entrance_date")
        private Timestamp entrance_date;

}
