package be.ipl.pfe.dal.repositories;

import be.ipl.pfe.dal.models.Citizen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepository extends CrudRepository<Citizen, Integer> {
}
