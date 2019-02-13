package com.vaccari.matteo.account.exceptions;

public class NegativeAmountForWithdrawalException extends Exception {

    public NegativeAmountForWithdrawalException () {
        System.out.println("Montant entré négatif, erreur");
    }
}
