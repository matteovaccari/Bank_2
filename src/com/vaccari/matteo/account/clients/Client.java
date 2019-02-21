package com.vaccari.matteo.account.clients;

import com.vaccari.matteo.account.Bank;
import com.vaccari.matteo.account.accounts.Account;
import com.vaccari.matteo.account.accounts.CurrentAccount;
import com.vaccari.matteo.account.accounts.SavingAccount;
import com.vaccari.matteo.account.exceptions.InsufisiantBalanceForWithdrawalException;
import com.vaccari.matteo.account.exceptions.NegativeAmountForDepositException;
import com.vaccari.matteo.account.exceptions.NegativeAmountForWithdrawalException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {

    // Attributs du client

    public String name;
    public CurrentAccount currentAccount = null;
    public SavingAccount savingAccount = null;
    public Bank bank;
    public int id;
    public static int totalID = 0;



    // Constructeur

    public Client () {

    }
    public Client(String name) {
        this.name = name;
        this.id = ++totalID;
        this.currentAccount = new CurrentAccount(name);
    }

    //Méthodes

    public void showInfo() { // Voir ID + solde
        System.out.println(this.name + ", identifiant bancaire :" + this.id + " dispose de " + this.currentAccount.balance + "€ sur son compte courant");
        if (this.savingAccount != null) {
            System.out.println("Et également de " + this.savingAccount.balance + "€ sur son compte épargne");
        }
    }

    public void showBalance() { // Voir solde

        System.out.println(this.name + " dispose de " + this.currentAccount.balance + "€ sur son compte courant.");
        if (this.savingAccount != null) {
            System.out.println(this.name + " dispose de " + this.savingAccount.balance + "€ sur son compte épargne.");
        }
    }

    public void deposit(int howMuch, Client client) throws NegativeAmountForDepositException {

        if (howMuch <= 0) {
            throw new NegativeAmountForDepositException("Negative amount not allowed for deposits");
        }
        currentAccount.balance += howMuch;
           System.out.println(this.name + " vient de déposer " + howMuch + "€ sur son compte courant.");
           Bank.addDepositToHistoryList(howMuch, client);
    }

    public void withdrawal(int howMuch, Client client) throws InsufisiantBalanceForWithdrawalException, NegativeAmountForWithdrawalException {

        if (howMuch < 0) {
            throw new NegativeAmountForWithdrawalException("Negative amount not allowed for withdrawals");
        }
        if (this.currentAccount.balance < howMuch) {
            throw new InsufisiantBalanceForWithdrawalException("Insufisiant balance not allowed for withdrawals");
        }

                this.currentAccount.balance -= howMuch;
                System.out.println(this.name + " a retiré " + howMuch + "€ sur son compte courant, son nouveau solde est de "
                        + this.currentAccount.balance + "€.");
               Bank.addWithDrawalToHistoryList(howMuch, client);

            }



   public void showAccounts () {
        System.out.println("Liste des comptes de " + this.name + " :");
        if (this.currentAccount != null) {
            System.out.println("-Un compte courant");
        } else {
            System.out.println("Aucun compte courant enregistré");
        }
        if (this.savingAccount != null) {
            System.out.println("-Un compte épargne");
        } else {
            System.out.println("Aucun compte épargne enregistré");
        }
    }
   }







