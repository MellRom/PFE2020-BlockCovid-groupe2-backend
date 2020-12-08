package be.ipl.pfe.dal.repositories;

import be.ipl.pfe.dal.models.WebUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebUserRepository extends CrudRepository<WebUser, Integer> {
    @Query("select new be.ipl.pfe.dal.models.WebUser(u.user_id,u.login,u.password, u.role) " +
            "FROM WebUser as u " +
            "where u.login = ?1")
    WebUser checkLogin(String login);
}