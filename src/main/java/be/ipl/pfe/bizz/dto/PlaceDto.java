package be.ipl.pfe.bizz.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Getter
@Setter
public class PlaceDto implements Serializable {


        @Id
        private int place_id;

        @Nullable
        private String name;

        @Nullable
        private String description;

        @JsonBackReference
        private WebUserDto webUser;

        @Nullable
        @JsonIgnore
        private Set<VisitDto> visits;

}

