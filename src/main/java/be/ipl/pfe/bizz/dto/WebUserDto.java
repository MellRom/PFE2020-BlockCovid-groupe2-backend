package be.ipl.pfe.bizz.dto;

import be.ipl.pfe.dal.models.WebUser;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class WebUserDto implements Serializable {

    @Id
    private int user_id;

    @Nullable
    private String login;

    @Nullable
    private String password;

    @Nullable
    private WebUser.Role role;

    @Nullable
    private String adress;

    @Nullable
    private String name;

    @Nullable
    private String address;

    @Nullable
    @JsonManagedReference
    private Set<PlaceDto> places;
}
