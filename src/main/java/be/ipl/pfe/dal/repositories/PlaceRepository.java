package be.ipl.pfe.dal.repositories;

import be.ipl.pfe.dal.models.Place;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlaceRepository extends CrudRepository<Place, Integer> {

    List<Place> getPlacesForEstablishment(int id_establishment);

}
