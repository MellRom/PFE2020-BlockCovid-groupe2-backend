package be.ipl.pfe.bizz.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor
public class DoctorDto implements Serializable {

    @Setter
    @Getter
    @Id
    @Nullable
    private int id;



    public DoctorDto(int id) {
        this.id = id;
    }
}
