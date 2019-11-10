package springweb.demo.bank.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb.demo.bank.exception.NotFoundException;
import springweb.demo.bank.model.BankListDemo;
import springweb.demo.bank.model.BankListDemoDto;
import springweb.demo.bank.repo.IBankListRepository;

@Service
public class BankListDemoService {
	
	@Autowired 
	private IBankListRepository repository;

	public BankListDemo insertOrUpdate(BankListDemoDto bankListDemoDto) {		
		return repository.save(toEntity(bankListDemoDto));
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}	

	public List<BankListDemo> list() {
		return (List<BankListDemo>) repository.findAll();
	}

	public BankListDemo getBankListDemoById(long id) {
		Optional<BankListDemo> optionalBankListDemo = repository.findById(id);
		return optionalBankListDemo.orElseThrow(() -> new NotFoundException("BankListDemo with id: " + id + " could not discovered"));
	}

	private BankListDemo toEntity(BankListDemoDto bankListDemoDto) {
		BankListDemo entity = new BankListDemo();
		entity.setBankName(bankListDemoDto.getBankname());
		entity.setType(bankListDemoDto.getType());
		entity.setCreated(new Date());
		
		return entity;
	}

}
