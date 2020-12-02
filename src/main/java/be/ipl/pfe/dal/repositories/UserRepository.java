package be.ipl.pfe.dal.repositories;

import be.ipl.pfe.dal.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("select new be.ipl.pfe.dal.models.User(u.id, u.login, u.password) " +
            "FROM User as u " +
            "where u.login = ?1 and u.password = ?2")
    User checkConnexion(String login, String password);
}