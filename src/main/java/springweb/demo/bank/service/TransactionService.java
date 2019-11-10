package springweb.demo.bank.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb.demo.bank.model.Transaction;
import springweb.demo.bank.model.TransactionDto;
import springweb.demo.bank.repo.ITransactionRepository;

@Service
public class TransactionService {
	
	@Autowired 
	private ITransactionRepository repository;

	public Transaction insertOne(TransactionDto dto) {		
		return repository.save(toEntity(dto));
	}
	
	public Transaction insertOne(Transaction entity) {		
		return repository.save(entity);
	}
	
	public List<Transaction> list() {
		return (List<Transaction>) repository.findAll();
	}


	private Transaction toEntity(TransactionDto dto) {
		Transaction entity = new Transaction();
		entity.setName(dto.getName());
		entity.setFt(dto.getFt());
		entity.setMark(dto.getMark());
		entity.setCreated(new Date());
		
		return entity;
	}

}
