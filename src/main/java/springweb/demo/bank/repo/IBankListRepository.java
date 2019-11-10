package springweb.demo.bank.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springweb.demo.bank.model.BankListDemo;

@Repository
public interface IBankListRepository extends CrudRepository<BankListDemo, Long> {
	
	List<BankListDemo> findByBankName(String bankname);
	
}
