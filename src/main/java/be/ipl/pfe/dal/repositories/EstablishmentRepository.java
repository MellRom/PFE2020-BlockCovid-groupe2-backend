package be.ipl.pfe.dal.repositories;

import be.ipl.pfe.dal.models.Establishment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablishmentRepository extends CrudRepository<Establishment, Integer> {

}