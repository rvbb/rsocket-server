package om.rvbb.b2b.backend.customer.repository;

import java.util.List;

import om.rvbb.b2b.backend.customer.entity.BankListDemo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBankListRepository extends CrudRepository<BankListDemo, Long> {
	
	List<BankListDemo> findByBankName(String bankname);
	
}
