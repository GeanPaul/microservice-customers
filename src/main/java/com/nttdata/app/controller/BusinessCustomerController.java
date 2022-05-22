package com.nttdata.app.controller;

import com.nttdata.app.document.BusinessCustomer;
import com.nttdata.app.service.impl.BusinessCustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/business-customers")
public class BusinessCustomerController {

    @Autowired
    private BusinessCustomerServiceImpl businessCustomerServiceImpl;

    @RequestMapping
    public ResponseEntity<Flux<BusinessCustomer>>getAllBusinessCustomer(){
        Flux<BusinessCustomer> flujo=businessCustomerServiceImpl.getAllBusinessCustomer();
        return new ResponseEntity<>(flujo, HttpStatus.OK);
    }

}
