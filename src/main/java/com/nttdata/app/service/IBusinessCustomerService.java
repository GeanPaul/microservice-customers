package com.nttdata.app.service;

import com.nttdata.app.document.BusinessCustomer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBusinessCustomerService {
    Flux<BusinessCustomer> getAllBusinessCustomer();
    Mono<BusinessCustomer> getByIdBusinessCustomer(String id);
    Mono<BusinessCustomer>createBusinessustomer(BusinessCustomer businessCustomer);
    Mono<BusinessCustomer>updateBusinessCustomer(BusinessCustomer businessCustomer);
    Mono<Void>deleteBusinessCustomer(BusinessCustomer businessCustomer);
}
