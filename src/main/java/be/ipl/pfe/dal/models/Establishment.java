package be.ipl.pfe.dal.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "establishment",schema = "projetpfe")
public class Establishment implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Getter
    @Setter
    @Column(name = "address")
    private String address;

    @Getter
    @Setter
    @Column(name = "name_establishment")
    private String name;

    public Establishment(int id, String address, String name) {
        this.id = id;
        this.address = address;
        this.name = name;
    }
}
