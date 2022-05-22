package com.nttdata.app.service.impl;

import com.nttdata.app.document.BusinessCustomer;
import com.nttdata.app.repository.IBusinessCustomerRepository;
import com.nttdata.app.service.IBusinessCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BusinessCustomerServiceImpl implements IBusinessCustomerService {
    @Autowired
    private IBusinessCustomerRepository businessCustomerRepository;

    @Override
    public Flux<BusinessCustomer> getAllBusinessCustomer() {
        return businessCustomerRepository.findAll();
    }

    @Override
    public Mono<BusinessCustomer> getByIdBusinessCustomer() {
        return null;
    }

    @Override
    public Mono<BusinessCustomer> createBusinessustomer() {
        return null;
    }

    @Override
    public Mono<BusinessCustomer> updateBusinessCustomer() {
        return null;
    }

    @Override
    public Mono<BusinessCustomer> deleteBusinessCustomer() {
        return null;
    }
}
