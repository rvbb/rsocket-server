package com.smartoscfintech.p2plending.lms.backend.loan.repository;

import com.smartoscfintech.p2plending.lms.backend.loan.entity.Crud;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMongoCrudRepository extends MongoRepository<Crud, String> {

}
