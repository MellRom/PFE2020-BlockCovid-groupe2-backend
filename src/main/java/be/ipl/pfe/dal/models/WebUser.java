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

    /*@OneToOne(fetch = FetchType.LAZY, mappedBy = "webUser")
    @Fetch(FetchMode.JOIN)
    private Establishment establishment;*/

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
