package be.ipl.pfe.dal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "doctor",schema = "projetpfe")
public class Doctor implements Serializable {

    @Id
    /*@PrimaryKeyJoinColumn
    @OneToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)*/
    private /*WebUser*/int doctor_id;
}
