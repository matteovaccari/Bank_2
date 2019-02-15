package com.vaccari.matteo.account.exceptions;

public class InsufisiantBalanceForBankTransferException extends Exception {

    public InsufisiantBalanceForBankTransferException() {
        System.out.println("Virement impossible pour cause de solde insufissant.");
    }

    public InsufisiantBalanceForBankTransferException(String message) {
        super(message);
    }

}
