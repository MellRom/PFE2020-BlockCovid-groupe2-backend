package be.ipl.pfe.dal.repositories;

import be.ipl.pfe.dal.models.Place;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlaceRepository extends CrudRepository<Place, Integer> {

}