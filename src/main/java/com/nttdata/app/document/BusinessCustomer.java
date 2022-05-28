package com.nttdata.app.document;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 *Esta clase es la representacion de un tipo de cliente como persona jurídica
 * */
@Data
@ToString
@Document(collection = "businessCustomer")
public class BusinessCustomer {

    //Atributo id del cliente como persona jurídica
    @Id
    private String idCustomer;
    //Atributo de razon social de la persona jurídica
    private String businessName;
    //Atributo de numero de ruc como persona jurídica
    private String rucNumber;
    //Atributo de lista de firmantes como persona juridica
    private List<String> signaturies;
    //Atributo de lista de titulares como persona jurídica
    private List<String> headlines;

}
