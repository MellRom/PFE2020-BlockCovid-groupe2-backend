package be.ipl.pfe.dal.repositories;

import be.ipl.pfe.bizz.dto.HelloWorldDto;
import be.ipl.pfe.dal.models.HelloWorld;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloWorldRepository extends CrudRepository<HelloWorld, String> {
    @Query("SELECT new be.ipl.pfe.dal.models.HelloWorld(h.id_helloworld) FROM HelloWorld h")
    HelloWorldDto getHelloWorld();
}
