package be.ipl.pfe.dal.repositories;

import be.ipl.pfe.dal.models.Establishment;
import be.ipl.pfe.dal.models.WebUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablishmentRepository extends CrudRepository<Establishment, Integer> {

}