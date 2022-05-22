package com.nttdata.app.service.impl;

import com.nttdata.app.document.PersonalCustomer;
import com.nttdata.app.repository.IPersonalCustomerRepository;
import com.nttdata.app.service.IPersonalCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonalCustomerServiceImpl implements IPersonalCustomerService {

    @Autowired
    private IPersonalCustomerRepository personalCustomerRepository;

    @Override
    public Flux<PersonalCustomer> getAllPersonalCustomer() {
        return personalCustomerRepository.findAll();
    }

    @Override
    public Mono<PersonalCustomer> getByIdPersonalCustomer() {
        return null;
    }

    @Override
    public Mono<PersonalCustomer> createPersonalCustomer() {
        return null;
    }

    @Override
    public Mono<PersonalCustomer> updatePersonalCustomer() {
        return null;
    }

    @Override
    public Mono<PersonalCustomer> deletePersonalCustomer() {
        return null;
    }
}
