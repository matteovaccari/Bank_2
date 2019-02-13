package com.vaccari.matteo.account.exceptions;

public class InsufisiantBalanceForWithdrawalException extends Exception {

    public InsufisiantBalanceForWithdrawalException() {
        System.out.println("Solde insufisant pour retrait, erreur.");
    }
}
