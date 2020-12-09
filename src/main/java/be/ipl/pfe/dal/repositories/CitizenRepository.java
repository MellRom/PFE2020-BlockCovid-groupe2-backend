package be.ipl.pfe.dal.repositories;

import be.ipl.pfe.dal.models.Citizen;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepository extends CrudRepository<Citizen, String> {
    @Query("select new be.ipl.pfe.dal.models.Citizen(c.citizen_id) " +
            "FROM Citizen as c " +
            "where c.citizen_id = ?1")
    Citizen checkId(String id);
}
