package com.smartoscfintech.p2plending.lms.backend.loan.repository;

import java.util.List;

import com.smartoscfintech.p2plending.lms.backend.loan.entity.Crud;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface IMongoCrudRepository extends CrudRepository<Crud, String> {

}
