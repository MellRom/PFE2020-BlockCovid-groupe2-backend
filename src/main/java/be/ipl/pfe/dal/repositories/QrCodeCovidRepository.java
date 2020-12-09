package be.ipl.pfe.dal.repositories;

import be.ipl.pfe.dal.models.QrCodeCovid;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QrCodeCovidRepository extends CrudRepository<QrCodeCovid, String> {
}
