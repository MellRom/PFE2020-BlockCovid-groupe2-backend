package be.ipl.pfe.dal.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
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


    public Establishment(int id, String address) {
        this.id = id;
        this.address = address;
    }
}
