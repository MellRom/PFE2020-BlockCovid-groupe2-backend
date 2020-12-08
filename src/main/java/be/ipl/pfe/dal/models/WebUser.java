package be.ipl.pfe.dal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    @OneToMany(targetEntity = Place.class,mappedBy = "webUser", fetch = FetchType.LAZY)
    @OrderBy("place_id")
    private List<Place> places;

    @Column(name = "address")
    private String address;

    public WebUser(int user_id, String login,String password, Role role){
        this.user_id = user_id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public enum Role {
        doctor,
        establishment
    }
}
