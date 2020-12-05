package be.ipl.pfe.bizz.dto;


import be.ipl.pfe.dal.models.WebUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DoctorDto implements Serializable {


    @Id
    private WebUserDto user_id;
}
