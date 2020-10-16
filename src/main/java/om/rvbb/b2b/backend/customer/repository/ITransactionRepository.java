package om.rvbb.b2b.backend.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import om.rvbb.b2b.backend.customer.entity.Transaction;

@Repository
public interface ITransactionRepository extends MongoRepository<Transaction, String> {
	
//	List<Transaction> findByDate(String created, String format);
	
}
