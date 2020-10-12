package com.smartoscfintech.p2plending.lms.backend.loan.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smartoscfintech.p2plending.lms.backend.loan.entity.Transaction;

@Repository
public interface ITransactionRepository extends MongoRepository<Transaction, String> {
	
//	List<Transaction> findByDate(String created, String format);
	
}
