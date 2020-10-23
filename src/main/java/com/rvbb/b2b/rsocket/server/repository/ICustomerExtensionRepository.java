package com.rvbb.b2b.rsocket.server.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerExtensionRepository{
	String getSomeComplexityData();
}
