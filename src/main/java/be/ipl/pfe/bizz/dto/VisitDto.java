package be.ipl.pfe.bizz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;
@NoArgsConstructor
@AllArgsConstructor
public class VisitDto implements Serializable{

        @Setter
        @Getter
        @Id
        @Nullable
        private int place_id;

        @Setter
        @Getter
        @Id
        @Nullable
        private int citizen_id;

        @Getter
        @Setter
        @Id
        @Nullable
        private Timestamp entrance_date;

}
