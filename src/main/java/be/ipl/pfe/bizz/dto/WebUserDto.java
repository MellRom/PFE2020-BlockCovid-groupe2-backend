package be.ipl.pfe.bizz.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.Id;

@NoArgsConstructor
public class WebUserDto {

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

    public WebUserDto(int id, int login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }
}
