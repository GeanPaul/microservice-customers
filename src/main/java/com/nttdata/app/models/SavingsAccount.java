package com.nttdata.app.models;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SavingsAccount {
    //nombre del tipo de cuenta
    private String typeAccount;
    //Atributo del número de cuenta de ahorro
    private String numberAccount;
    //Saldo de la cuenta de ahorro
    private double accountBalance;
    //Costo de mantenimiento de la cuenta de ahorro
    private double maintenanceCost;
    //Limite de movimientos de la cuenta de ahorro
    private int movementLimit;
}
