package be.ipl.pfe;

import be.ipl.pfe.bizz.dto.CitizenDto;
import be.ipl.pfe.dal.daoImpl.CitizenService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CitizenServiceTest {
    @Autowired
    private CitizenService citizenService;

    @Test
    void inscriptionHasNewGeneratedId(){
        CitizenDto savedCitizen = citizenService.inscription();
        assertAll(
                () ->assertNotNull(savedCitizen.getCitizen_id()),
                () ->assertTrue(savedCitizen.getCitizen_id() > 0));
        System.out.println("Test fonctionnel");
    }
}
