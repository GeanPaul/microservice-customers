package com.nttdata.app.repository;

import com.nttdata.app.document.PersonalCustomer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IPersonalCustomerRepository extends ReactiveMongoRepository<PersonalCustomer,String> {
}
