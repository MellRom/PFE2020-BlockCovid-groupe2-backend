package be.ipl.pfe.bizz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class WebUserDto implements Serializable {

    @Setter
    @Getter
    @Id
    @Nullable
    private int user_id;

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

}
