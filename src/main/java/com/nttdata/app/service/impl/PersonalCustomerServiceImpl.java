package com.nttdata.app.service.impl;

import com.nttdata.app.controller.PersonalCustomerController;
import com.nttdata.app.document.PersonalCustomer;
import com.nttdata.app.repository.IPersonalCustomerRepository;
import com.nttdata.app.service.IPersonalCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PersonalCustomerServiceImpl implements IPersonalCustomerService {

    @Autowired
    private IPersonalCustomerRepository personalCustomerRepository;


    @Override
    public Flux<PersonalCustomer> getAllPersonalCustomer() {
        return personalCustomerRepository.findAll();
    }

    @Override
    public Mono<PersonalCustomer> getByIdPersonalCustomer(String id) {
        return personalCustomerRepository.findById(id);
    }

    @Override
    public Mono<PersonalCustomer> updatePersonalCustomerById(PersonalCustomer personalCustomer) {
        return personalCustomerRepository.save(personalCustomer);
    }

    @Override
    public Mono<PersonalCustomer> createPersonalCustomer(PersonalCustomer personalCustomer) {
        return personalCustomerRepository.save(personalCustomer);
    }

    @Override
    public Mono<Void> deletePersonalCustomer(PersonalCustomer personalCustomer) {
         return personalCustomerRepository.delete(personalCustomer);
    }
}
