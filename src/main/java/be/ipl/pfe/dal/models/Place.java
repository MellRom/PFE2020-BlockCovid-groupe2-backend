package be.ipl.pfe.dal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "place",schema = "projetpfe")
public class Place implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private int place_id;

        @Column(name = "name")
        private String name;

        @Column(name = "description")
        private String description;

        @Column(name= "id_establishment")
        private int id_establishment;

}
