package com.smartoscfintech.p2plending.lms.backend.loan.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.smartoscfintech.p2plending.lms.backend.loan.exception.NotFoundException;
import com.smartoscfintech.p2plending.lms.backend.loan.entity.Crud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartoscfintech.p2plending.lms.backend.loan.repository.IMongoCrudRepository;
import com.smartoscfintech.p2plending.lms.backend.loan.model.CrudDto;
import com.smartoscfintech.p2plending.lms.backend.loan.entity.Crud;

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
