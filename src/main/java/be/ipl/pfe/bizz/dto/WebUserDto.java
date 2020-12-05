package be.ipl.pfe.bizz.dto;

import be.ipl.pfe.dal.models.WebUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class WebUserDto{

    @Id
    private int user_id;

    private String login;

    @Nullable
    private String password;

    private WebUser.Role role;

    @Nullable
    private String adress;

    @Nullable
    private String name;

}
