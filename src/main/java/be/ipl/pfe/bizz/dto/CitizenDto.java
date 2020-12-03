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
public class CitizenDto implements Serializable {

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

}
