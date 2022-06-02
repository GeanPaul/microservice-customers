package com.nttdata.app.models;

import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalCredit {
    //Atributo del tipo de crédito
    private String typeCredit;
    //Atributo del número interno del banco del crédito
    private String numberCredit;
    //Atributo del monto del crédito
    private double creditAmount;
    //Atributo de saldo disponible
    private double availableBalance;
}
