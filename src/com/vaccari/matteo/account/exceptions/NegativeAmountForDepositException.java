package com.vaccari.matteo.account.exceptions;

public class NegativeAmountForDepositException extends Exception {
    public NegativeAmountForDepositException() {
        System.out.println("Montant du dépôt entré négatif, erreur");
    }
    public NegativeAmountForDepositException(String message) {
        super(message);
    }
}
