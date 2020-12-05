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
@Table(name = "web_user",schema = "projetpfe")
public class WebUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int user_id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    /*@OneToOne(targetEntity = Doctor.class, mappedBy = "doctor_id", fetch = FetchType.LAZY)
    private Doctor doctor_id;*/

    public WebUser(int user_id, String login, Role role){
        this.user_id = user_id;
        this.login = login;
        this.role = role;
    }

    public enum Role {
        doctor,
        establishment
    }
}
