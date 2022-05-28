package com.nttdata.app.service;

import com.nttdata.app.document.PersonalCustomer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonalCustomerService {
 Flux<PersonalCustomer> getAllPersonalCustomer();
Mono<PersonalCustomer>getByIdPersonalCustomer(String id);
Mono<PersonalCustomer>updatePersonalCustomerById(PersonalCustomer personalCustomer);
Mono<PersonalCustomer> createPersonalCustomer(PersonalCustomer personalCustomer);
Mono<Void>deletePersonalCustomer(PersonalCustomer personalCustomer);


}
