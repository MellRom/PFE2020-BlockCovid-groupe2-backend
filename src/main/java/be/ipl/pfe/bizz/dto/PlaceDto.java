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
public class PlaceDto implements Serializable {

        @Getter
        @Setter
        @Id
        private int place_id;

        @Getter
        @Setter
        @Nullable
        private String name;

        @Getter
        @Setter
        @Nullable
        private String description;

        @Getter
        @Setter
        private int id_establishment;
}

