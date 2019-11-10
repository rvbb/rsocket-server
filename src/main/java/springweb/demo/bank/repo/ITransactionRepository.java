package springweb.demo.bank.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import springweb.demo.bank.model.Transaction;

@Repository
public interface ITransactionRepository extends MongoRepository<Transaction, String> {
	
//	List<Transaction> findByDate(String created, String format);
	
}
