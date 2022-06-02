package com.nttdata.app.models;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FixedTermAccount {

    //Nombre del tipo de cuenta
    private String typeAccount;
    //Atributo del número de cuenta de ahorro a plazo fijo
    private String numberFixedTermAccount;
    //Saldo de la cuenta de ahorro a plazo fijo
    private double accountBalance;
    //Límite de movimientos de la cuenta de ahorro a plazo fijo
    private int movementLimit;
    //Fecha en la que puede realizar cualquier movimiento
    private String moveDate;
    //id del cliente de la cuenta
}
