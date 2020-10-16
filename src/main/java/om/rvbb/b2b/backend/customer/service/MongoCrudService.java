package om.rvbb.b2b.backend.customer.service;

import java.util.List;
import java.util.Optional;

import om.rvbb.b2b.backend.customer.exception.NotFoundException;
import om.rvbb.b2b.backend.customer.model.CrudDto;
import om.rvbb.b2b.backend.customer.entity.Crud;
import om.rvbb.b2b.backend.customer.repository.IMongoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoCrudService {

    @Autowired
    private IMongoCrudRepository repository;

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<Crud> list() {
        return (List<Crud>) repository.findAll();
    }

    public Crud get(String id) {
        Optional<Crud> optionalCrud = repository.findById(id);
        return optionalCrud.orElseThrow(() -> new NotFoundException("Crud with id: " + id + " could not discovered"));
    }

    public Crud upsert(CrudDto crudDto) {
        return repository.save(toEntity(crudDto));
    }

    public Crud toEntity(CrudDto dto) {
        Crud entity = new Crud();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());

        return entity;
    }
}
