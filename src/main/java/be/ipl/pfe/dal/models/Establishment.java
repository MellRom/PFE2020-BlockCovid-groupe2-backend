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
    private int user_id;

    @Getter
    @Setter
    @Column(name = "address")
    private String address;


    public Establishment(int user_id, String address) {
        this.user_id = user_id;
        this.address = address;
    }
}
