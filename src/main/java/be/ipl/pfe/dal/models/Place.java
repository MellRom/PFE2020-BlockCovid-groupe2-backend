package be.ipl.pfe.dal.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "place", schema = "projetpfe")
public class Place implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int place_id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @JoinColumn(name = "id_establishment")
    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private WebUser webUser;

    @OneToMany(targetEntity = Visit.class, mappedBy = "place", fetch = FetchType.LAZY)
    private Set<Visit> visits;
}
