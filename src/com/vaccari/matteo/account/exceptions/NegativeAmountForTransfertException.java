package com.vaccari.matteo.account.exceptions;

public class NegativeAmountForTransfertException extends Exception {
    public NegativeAmountForTransfertException() {
        System.out.println("Montant du virement négatif, erreur.");
    }
}
