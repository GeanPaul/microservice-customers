package com.nttdata.app.controller;

import com.nttdata.app.document.BusinessCustomer;
import com.nttdata.app.document.PersonalCustomer;
import com.nttdata.app.models.BusinessCredit;
import com.nttdata.app.models.CurrentAccount;
import com.nttdata.app.models.PersonalCredit;
import com.nttdata.app.service.impl.BusinessCustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/business-customers")
public class BusinessCustomerController {

    @Autowired
    private BusinessCustomerServiceImpl businessCustomerServiceImpl;

    @GetMapping
    public Flux<BusinessCustomer>getAllBusinessCustomer(){
        log.info("Business Customer All");
        return businessCustomerServiceImpl.getAllBusinessCustomer();
    }

    @GetMapping("/{id}")
    public Mono<BusinessCustomer> getBusinessCustomerById(@PathVariable String id){
        log.info("Business customer as id: " + id);
        return businessCustomerServiceImpl.getByIdBusinessCustomer(id);
    }

    @PostMapping("/create")
    public  Mono<BusinessCustomer>createBusinessCustomer(@RequestBody BusinessCustomer businessCustomer )
    {
        log.info("Business customer created " +" -- "+ businessCustomer.toString());
        return  businessCustomerServiceImpl.createBusinessustomer(businessCustomer);
    }

    @PutMapping("/update")
    public Mono<BusinessCustomer> updateBusinessCustomer(@RequestBody BusinessCustomer businessCustomer) {
        Mono<BusinessCustomer> mono=businessCustomerServiceImpl.getByIdBusinessCustomer(businessCustomer.getIdCustomer());
        return mono.flatMap(c ->{
            c.setBusinessName(businessCustomer.getBusinessName());
            c.setHeadlines(businessCustomer.getHeadlines());
            c.setSignaturies(businessCustomer.getSignaturies());
            c.setRucNumber(businessCustomer.getRucNumber());
            log.info("Business Customer updated "+" -- "+ c.toString());
            return businessCustomerServiceImpl.updateBusinessCustomer(c);
        });


    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteBusinessCustomerById( @PathVariable String id){
        Mono<BusinessCustomer> mono=businessCustomerServiceImpl.getByIdBusinessCustomer(id);
        return mono.flatMap(c->
        {
            log.info("Business Customer as Id " + id + " is Deleted" );
            return businessCustomerServiceImpl.deleteBusinessCustomer(c);
        });

    }

    //=========== CONEXION CON MICROSERVICE CREDITS==================

    @GetMapping("/credits/{idCustomer}")
    public Flux<BusinessCredit>getBusinessCreditFindIdCustomer(@PathVariable String idCustomer)
    {
        return businessCustomerServiceImpl.getBusinessCreditByIdCustomer(idCustomer);
    }

    @GetMapping("/current-account/{idCustomer}")
    public Flux<CurrentAccount> getAllCurrentAccountsPersonalByIdCustomer(@PathVariable String idCustomer)
    {
        return  businessCustomerServiceImpl.getCurrentAccountBusinessByIdCustomer(idCustomer);

    }




}
