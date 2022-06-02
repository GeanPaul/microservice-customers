package com.nttdata.app.models;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurrentAccount {

    //Atributo del tipo de cuenta
    private String typeAccount;
    //Atributo del numero de cuenta
    private String numberCurrentAccount;
    //Saldo de la cuenta corriente
    private double accountBalance;
    //Costo de mantenimiento de la cuenta corriente
    private double maintenanceCost;
}
