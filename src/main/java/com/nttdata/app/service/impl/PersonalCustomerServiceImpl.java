package com.nttdata.app.service.impl;

import com.nttdata.app.controller.PersonalCustomerController;
import com.nttdata.app.document.PersonalCustomer;
import com.nttdata.app.models.*;
import com.nttdata.app.repository.IPersonalCustomerRepository;
import com.nttdata.app.service.IPersonalCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PersonalCustomerServiceImpl implements IPersonalCustomerService {

    @Autowired
    private IPersonalCustomerRepository personalCustomerRepository;
    @Autowired
    private RestTemplate restTemplate;


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

    //Metodos para obtener data de microservice Credits y Accounts
    public Mono<PersonalCredit>getPersonalCreditByIdCustomer(String idCustomer ){
        PersonalCredit pc=restTemplate.getForObject("http://localhost:8083/credits/credit-personal/"+idCustomer,PersonalCredit.class);
        return Mono.just(pc);
    }

    public Mono<SavingsAccount>getSavingsAccountByIdCustomer(String idCustomer ){
        SavingsAccount sa=restTemplate.getForObject("http://localhost:8081/savings-accounts/personalcustomer/"+idCustomer,SavingsAccount.class);
        return Mono.just(sa);
    }

    public Flux<CurrentAccount>getCurrentAccountPersonalByIdCustomer(String idCustomer ){
        List<CurrentAccount> ca=restTemplate.getForObject("http://localhost:8081/current-accounts/customer/"+idCustomer,List.class);
        return Flux.fromIterable(ca);
    }

    public Flux<FixedTermAccount>getFixedTermAccountPersonalByIdCustomer(String idCustomer ){
        List<FixedTermAccount> fa=restTemplate.getForObject("http://localhost:8081/fixedterm-accounts/customer/"+idCustomer,List.class);
        return Flux.fromIterable(fa);
    }






}
