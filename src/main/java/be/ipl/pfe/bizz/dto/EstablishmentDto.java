package be.ipl.pfe.bizz.dto;


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
public class EstablishmentDto implements Serializable {


    @Id
    private int user_id;

    @Nullable
    private String address;

    @JsonManagedReference
    private Set<PlaceDto> places;

}
