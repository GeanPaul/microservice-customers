package com.nttdata.app.document;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//Clase que representa a una persona natural
@Data
@ToString
@Document(collection = "personalCustomer")
public class PersonalCustomer {
    //Id del cliente como persona natural
    @Id
    private String idPersonalCustomer;
    //Atributo primeros nombres del cliente como persona natural
    private String firstName;
    //Atributo de apellidos del cliente como persona natural
    private String lastName;
    //Atributo de numero de documento como persona natural
    private String documentNumber;
}
