package be.ipl.pfe.bizz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class VisitDto implements Serializable{

        @Id
        private int place_id;

        @Id
        private int citizen;

        @Id
        private Timestamp entrance_date;



}
