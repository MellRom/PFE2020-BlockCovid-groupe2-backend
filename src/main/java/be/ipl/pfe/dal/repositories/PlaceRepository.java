package be.ipl.pfe.dal.repositories;

import be.ipl.pfe.dal.models.Place;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Integer> {
    @Query("select new be.ipl.pfe.dal.models.Place(p.place_id, p.name,p.description,p.id_establishment) "+
            "FROM Place p WHERE p.id_establishment =?1")
    List<Place> getPlacesForEstablishment(int id_establishment);

}