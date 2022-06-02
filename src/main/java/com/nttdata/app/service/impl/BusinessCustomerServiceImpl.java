package com.nttdata.app.service.impl;

import com.nttdata.app.document.BusinessCustomer;
import com.nttdata.app.models.BusinessCredit;
import com.nttdata.app.models.CurrentAccount;
import com.nttdata.app.models.PersonalCredit;
import com.nttdata.app.repository.IBusinessCustomerRepository;
import com.nttdata.app.service.IBusinessCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusinessCustomerServiceImpl implements IBusinessCustomerService {
    @Autowired
    private IBusinessCustomerRepository businessCustomerRepository;
    @Autowired
    private RestTemplate restTemplate;

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

    public Flux<BusinessCredit>getBusinessCreditByIdCustomer(String idCustomer ){
        List<BusinessCredit> bc=restTemplate.getForObject("http://localhost:8083/credits/credit-business/"+idCustomer,List.class);
        return Flux.fromIterable(bc);
    }

    public Flux<CurrentAccount>getCurrentAccountBusinessByIdCustomer(String idCustomer ){
        List<CurrentAccount> ca=restTemplate.getForObject("http://localhost:8081/current-accounts/customer/"+idCustomer,List.class);
        return Flux.fromIterable(ca);
    }


}
