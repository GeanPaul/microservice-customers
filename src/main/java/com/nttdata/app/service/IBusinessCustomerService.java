package com.nttdata.app.service;

import com.nttdata.app.document.BusinessCustomer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBusinessCustomerService {
    Flux<BusinessCustomer> getAllBusinessCustomer();
    Mono<BusinessCustomer> getByIdBusinessCustomer();
    Mono<BusinessCustomer>createBusinessustomer();
    Mono<BusinessCustomer>updateBusinessCustomer();
    Mono<BusinessCustomer>deleteBusinessCustomer();
}
