package com.smartoscfintech.p2plending.lms.backend.loan.repository;

import java.util.List;

import com.smartoscfintech.p2plending.lms.backend.loan.entity.BankListDemo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBankListRepository extends CrudRepository<BankListDemo, Long> {
	
	List<BankListDemo> findByBankName(String bankname);
	
}
