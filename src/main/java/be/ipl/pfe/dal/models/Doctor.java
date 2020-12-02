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
    private int user_id;

    public Doctor(int user_id) {
        this.user_id = user_id;
    }
}
