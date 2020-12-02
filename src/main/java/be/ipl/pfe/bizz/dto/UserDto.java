package be.ipl.pfe.bizz.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.Id;

@NoArgsConstructor
public class UserDto {

    @Setter
    @Getter
    @Id
    @Nullable
    private int id;

    @Setter
    @Getter
    @Nullable
    private String login;

    @Getter
    @Setter
    @Nullable
    private String password;

    @Getter
    @Setter
    private String role;

    @Getter
    @Setter
    @Nullable
    private String adress;

    @Getter
    @Setter
    @Nullable
    private String name;

    public UserDto(int id, String login, String password, String role, String name) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.name = name;
    }
}
