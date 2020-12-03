package be.ipl.pfe.dal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "place",schema = "projetpfe")
public class Place implements Serializable {

        @Getter
        @Setter
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private int place_id;

        @Getter
        @Setter
        @Column(name = "name")
        private String name;

        @Getter
        @Setter
        @Column(name = "description")
        private String description;

        @Getter
        @Setter
        @Column(name= "id_establishment")
        private int id_establishment;

}
