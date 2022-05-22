package com.nttdata.app.repository;

import com.nttdata.app.document.BusinessCustomer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IBusinessCustomerRepository extends ReactiveMongoRepository<BusinessCustomer,String> {
}
