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
    public Mono<BusinessCustomer> getByIdBusinessCustomer(String id) {
        return businessCustomerRepository.findById(id);
    }

    @Override
    public Mono<BusinessCustomer> createBusinessustomer(BusinessCustomer businessCustomer) {
        return businessCustomerRepository.save(businessCustomer);
    }

    @Override
    public Mono<BusinessCustomer> updateBusinessCustomer(BusinessCustomer businessCustomer) {
        return businessCustomerRepository.save(businessCustomer);
    }

    @Override
    public Mono<Void> deleteBusinessCustomer(BusinessCustomer businessCustomer) {
        return businessCustomerRepository.delete(businessCustomer);
    }


}
