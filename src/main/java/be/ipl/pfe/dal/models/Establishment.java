package be.ipl.pfe.dal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

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

    @OneToMany(targetEntity = Place.class, mappedBy = "establishment", fetch = FetchType.LAZY)
    private Set<Place> places;
}
