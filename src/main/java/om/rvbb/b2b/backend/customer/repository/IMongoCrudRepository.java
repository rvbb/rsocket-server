package om.rvbb.b2b.backend.customer.repository;

import om.rvbb.b2b.backend.customer.entity.Crud;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMongoCrudRepository extends MongoRepository<Crud, String> {

}
