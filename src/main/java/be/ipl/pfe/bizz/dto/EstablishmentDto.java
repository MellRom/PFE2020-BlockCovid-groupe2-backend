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
public class EstablishmentDto implements Serializable {

    @Setter
    @Getter
    @Id
    @Nullable
    private int id;

    @Setter
    @Getter
    @Nullable
    private String name;

    @Setter
    @Getter
    @Nullable
    private String address;

}
