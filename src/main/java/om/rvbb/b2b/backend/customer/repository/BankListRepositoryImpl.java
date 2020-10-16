package om.rvbb.b2b.backend.customer.repository;

import java.util.List;
import java.util.Optional;

import om.rvbb.b2b.backend.customer.entity.BankListDemo;

public class BankListRepositoryImpl implements IBankListRepository {
	
	@Override
	public List<BankListDemo> findByBankName(String bankname) {
	
		return null;
	}

	@Override
	public <S extends BankListDemo> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BankListDemo> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<BankListDemo> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<BankListDemo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<BankListDemo> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(BankListDemo entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends BankListDemo> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
