package com.vaccari.matteo.account.accounts;

public class SavingAccount extends Account {


   public SavingAccount(String name) {
        this.name = "Compte épargne de " + name;
    }


    //Méthode qui fait fructifier le solde
    /**
     void investment (double amount) {
     double profit;
     this.balance -= amount;
     profit = amount * interestsRate;
     this.balance += profit;
     System.out.println("Investissement réussi: nouveau solde :");
     // RAjouter if (balance < 0) = fail
     }
     */
}
