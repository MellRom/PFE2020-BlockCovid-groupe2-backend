package be.ipl.pfe.dal.models;

import javax.persistence.*;


@Entity
@Table(name = "helloworld",schema = "projetpfe")
public class HelloWorld {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_helloworld;

    @Column(name = "name_h")
    private String name;

    public HelloWorld(int id_helloworld) {
        this.id_helloworld = id_helloworld;
    }

    public HelloWorld() {
    }

    public int getId() {
        return id_helloworld;
    }


    public void setId(int id_helloworld) {
        this.id_helloworld = id_helloworld;
    }

}
