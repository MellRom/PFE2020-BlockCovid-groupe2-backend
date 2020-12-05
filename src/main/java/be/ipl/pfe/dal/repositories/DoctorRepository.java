package be.ipl.pfe.dal.repositories;

import be.ipl.pfe.dal.models.Doctor;
import be.ipl.pfe.dal.models.WebUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, WebUser> {

}