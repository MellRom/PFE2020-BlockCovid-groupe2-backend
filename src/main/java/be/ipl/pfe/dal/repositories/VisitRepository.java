package be.ipl.pfe.dal.repositories;


import be.ipl.pfe.dal.models.Citizen;
import be.ipl.pfe.dal.models.Visit;
import be.ipl.pfe.dal.models.VisitId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;
import java.util.Set;

@Repository
public interface VisitRepository extends CrudRepository<Visit, VisitId> {
    @Query("SELECT DISTINCT new be.ipl.pfe.dal.models.Citizen(v.citizen.citizen_id) FROM Visit v WHERE v.citizen.citizen_id <> ?1 " +
            "AND v.place.place_id = ?2 AND v.entrance_date > ?3 AND v.entrance_date = ?4")
    Set<Citizen> selectContactCitizen(int citizen_id, int place_id, Timestamp entranceDateLower, Timestamp entranceDateUpper);
}
