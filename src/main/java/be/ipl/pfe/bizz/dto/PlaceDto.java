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
@Getter
@Setter
public class PlaceDto implements Serializable {


        @Id
        private int place_id;

        @Nullable
        private String name;

        @Nullable
        private String description;

        private int id_establishment;
}

