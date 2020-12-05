package be.ipl.pfe.dal.repositories;


import be.ipl.pfe.dal.models.Visit;
import be.ipl.pfe.dal.models.VisitId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends CrudRepository<Visit, VisitId> {
}
