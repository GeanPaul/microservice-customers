package com.nttdata.app.service;

import com.nttdata.app.document.PersonalCustomer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonalCustomerService {
Flux<PersonalCustomer>getAllPersonalCustomer();
Mono<PersonalCustomer>getByIdPersonalCustomer();
Mono<PersonalCustomer>createPersonalCustomer();
Mono<PersonalCustomer>updatePersonalCustomer();
Mono<PersonalCustomer>deletePersonalCustomer();

}
