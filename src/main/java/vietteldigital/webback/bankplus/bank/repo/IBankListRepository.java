package vietteldigital.webback.bankplus.bank.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vietteldigital.webback.bankplus.bank.model.BankListDemo;

@Repository
public interface IBankListRepository extends CrudRepository<BankListDemo, Long> {
	
	List<BankListDemo> findByBankName(String bankname);
	
}
