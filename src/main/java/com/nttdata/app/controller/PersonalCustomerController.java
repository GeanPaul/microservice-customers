package com.nttdata.app.controller;

import com.nttdata.app.config.RestTemplateConfig;
import com.nttdata.app.document.PersonalCustomer;
import com.nttdata.app.models.*;
import com.nttdata.app.service.impl.PersonalCustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/personal-customers")
public class PersonalCustomerController {

    @Autowired
    private PersonalCustomerServiceImpl personalCustomerServiceImpl;

    @Autowired
    private RestTemplateConfig restTemplateConfigu;


    @RequestMapping
    public Flux<PersonalCustomer> getAllPersonalCustomer() {
        log.info("All Personal Customers");
       return personalCustomerServiceImpl.getAllPersonalCustomer();
    }

    @GetMapping("/{id}")
    public Mono<PersonalCustomer> getAllPersonalCustomerById(@PathVariable String id) {
        log.info("Personal Customer by Id: " + id);
       return personalCustomerServiceImpl.getByIdPersonalCustomer(id);
    }

    @PostMapping("/create")
    public Mono<PersonalCustomer> savePersonalCustomer(@RequestBody PersonalCustomer personalCustomer) {
        log.info("Personal customer created " +" -- "+ personalCustomer.toString());
       return personalCustomerServiceImpl.createPersonalCustomer(personalCustomer);
    }

    @PutMapping("/update")
    public Mono<PersonalCustomer> updatePersonalCustomer(@RequestBody PersonalCustomer personalCustomer) {
        Mono<PersonalCustomer> mono=personalCustomerServiceImpl.getByIdPersonalCustomer(personalCustomer.getIdCustomer());
          return mono.flatMap(c ->{
            c.setFirstName(personalCustomer.getFirstName());
            c.setLastName(personalCustomer.getLastName());
            c.setDocumentNumber(personalCustomer.getDocumentNumber());
            log.info("Personal Customer updated "+" -- "+ c.toString());
        return personalCustomerServiceImpl.updatePersonalCustomerById(c);
        });


    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deletePersonalCustomerById( @PathVariable String id){
        Mono<PersonalCustomer> mono=personalCustomerServiceImpl.getByIdPersonalCustomer(id);
        return mono.flatMap(c->
        {
            log.info("Personal Customer as Id " + id + " is Deleted" );
            return personalCustomerServiceImpl.deletePersonalCustomer(c);
        });

    }


    // ========= CONEXION CON MICROSERVICIO CREDITS ==========

    @GetMapping("/credits/{idCustomer}")
        public Mono<PersonalCredit>getPersonalCreditFindIdCustomer( @PathVariable String idCustomer)
        {
            return personalCustomerServiceImpl.getPersonalCreditByIdCustomer(idCustomer);
        }

    @GetMapping("/savings-account/{idCustomer}")
    public Mono<SavingsAccount>getSavingsAccountsPersonalFindIdCustomer( @PathVariable String idCustomer)
    {
        return personalCustomerServiceImpl.getSavingsAccountByIdCustomer(idCustomer);
    }
    @GetMapping("/current-account/{idCustomer}")
    public Flux<CurrentAccount>getCurrentAccountPersonalFindIdCustomer( @PathVariable String idCustomer)
    {
        return personalCustomerServiceImpl.getCurrentAccountPersonalByIdCustomer(idCustomer);
    }

    @GetMapping("/fixedterm-account/{idCustomer}")
    public Flux<FixedTermAccount>getFixedTermAccountPersonalFindIdCustomer(@PathVariable String idCustomer)
    {
        return personalCustomerServiceImpl.getFixedTermAccountPersonalByIdCustomer(idCustomer);
    }























}

