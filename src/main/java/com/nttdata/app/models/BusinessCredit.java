package com.nttdata.app.models;


import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BusinessCredit {
    //Atributo del tipo de crédito
    private String typeCredit;
    //Atributo del número interno del banco del crédito
    private String numberCredit;
    //Atributo del monto del crédito
    private double creditAmount;
    //Atributo de saldo disponible
    private double availableBalance;

}
