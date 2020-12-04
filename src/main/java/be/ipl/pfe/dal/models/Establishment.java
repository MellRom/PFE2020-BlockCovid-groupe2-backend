package be.ipl.pfe.dal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "establishment",schema = "projetpfe")
public class Establishment implements Serializable {


    @Id
    private int user_id;

    @Column(name = "address")
    private String address;
}
