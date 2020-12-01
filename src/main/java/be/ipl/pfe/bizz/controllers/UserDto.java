package be.ipl.pfe.bizz.controllers;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor
public class UserDto implements Serializable {

    @Setter
    @Getter
    @Id
    @Nullable
    private int id;

    @Setter
    @Getter
    @Nullable
    private int login;

    @Getter
    @Setter
    @Nullable
    private String password;

    public UserDto(int id, int login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }
}
