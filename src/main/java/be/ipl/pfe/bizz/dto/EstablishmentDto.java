package be.ipl.pfe.bizz.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor
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


    public EstablishmentDto(int id, @Nullable String name, @Nullable String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
