package be.ipl.pfe.dal.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Table(name = "doctor",schema = "projetpfe")
public class Doctor implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    public Doctor(int id) {
        this.id = id;
    }
}
