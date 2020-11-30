package be.ipl.pfe.bizz.dto;

import javax.persistence.*;


public class HelloWorldDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
