package com.nttdata.app.controller;

import com.nttdata.app.document.PersonalCustomer;
import com.nttdata.app.service.impl.PersonalCustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/personal-customers")
public class PersonalCustomerController {

    @Autowired
    private PersonalCustomerServiceImpl personalCustomerServiceImpl;

    @RequestMapping
    public ResponseEntity<Flux<PersonalCustomer>>getAllPersonalCustomer()
    {
        Flux<PersonalCustomer> flujo=personalCustomerServiceImpl.getAllPersonalCustomer();
        return new ResponseEntity<>(flujo, HttpStatus.OK);
    }

}
