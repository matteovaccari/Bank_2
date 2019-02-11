import java.util.ArrayList;
import java.util.List;

public class Client {

    // Attributs du client

    String name;
    CurrentAccount currentAccount = null;
    SavingAccount savingAccount = null;
    Bank bank;
    int id;
    static int totalID=0;
    List<String> historyList = new ArrayList<>();

    // Constructeur

    Client(String name) {
        this.name = name;
        this.id = ++totalID;
    }

    //Méthodes

    void showInfo() { // Voir ID + solde
            System.out.println(this.name + ", identifiant bancaire :" + this.id + " dispose de " + this.currentAccount.balance + "€ sur son compte courant");
          if (this.savingAccount != null) {
            System.out.println(this.name + ", identifiant bancaire :" + this.id + " dispose de " + this.savingAccount.balance + "€ sur son compte épargne");
        }
    }

    void showBalance() { // Voir solde

            System.out.println(this.name + " dispose de " + this.currentAccount.balance + "€ sur son compte courant.");
          if (this.savingAccount != null) {
            System.out.println(this.name + " dispose de " + this.savingAccount.balance + "€ sur son compte épargne.");
        }
    }

    void deposit(int howMuch, Account whichAccount) {
        if (whichAccount == currentAccount) {
            this.currentAccount.balance += howMuch;
            System.out.println(this.name + " vient de déposer " + howMuch + "€ sur son compte courant.");
            historyList.add("Dépot de " + howMuch + "€ sur le compte courant, nouveau solde : " + this.currentAccount.balance + "€.");
        } else if (whichAccount == savingAccount) {
            this.savingAccount.balance += howMuch;
            System.out.println(this.name + " vient de déposer " + howMuch + "€ sur son compte épargne.");
            historyList.add("Dépot de " + howMuch + "€ sur le compte épargne, nouveau solde : " + this.savingAccount.balance + "€.");
        }
    }

    void withdrawal(int howMuch, Account whichAccount) {
        if (whichAccount == currentAccount) {
            if (howMuch > this.currentAccount.balance) {
                System.out.println(this.name + " a essayé de retirer " + howMuch + "€ de son compte courant mais il ne lui" +
                        " restait que " + this.currentAccount.balance + "€. Opération impossible.");
            } else if (howMuch <= this.currentAccount.balance) {
                this.currentAccount.balance -= howMuch;
                System.out.println(this.name + " a retiré " + howMuch + "€ sur son compte courant, son nouveau solde est de "
                        + this.currentAccount.balance + "€.");
                historyList.add("Retrait de " + howMuch + "€ sur le compte courant, nouveau solde : " + this.currentAccount.balance + "€.");
            }
        }

        else if (whichAccount == savingAccount) {
            if (howMuch > this.savingAccount.balance) {
                System.out.println(this.name + " a essayé de retirer " + howMuch + "€ de son compte épargne mais il ne lui" +
                        " restait que " + this.savingAccount.balance + "€. Opération impossible.");
            } else if (howMuch <= this.savingAccount.balance) {
                this.savingAccount.balance -= howMuch;
                System.out.println(this.name + " a retiré " + howMuch + "€ sur son compte épargne, son nouveau solde est de "
                        + this.savingAccount.balance + "€.");
                historyList.add("Retrait de " + howMuch + "€ sur le compte épargne, nouveau solde: " + this.savingAccount.balance + "€.");
            }

        }
    }

    void showAccounts () {
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

    void showHistory() {
        System.out.println("Voici l'historique du compte de " + this.name + " :");
        for (int i = 0; i < historyList.size(); i++) {
            System.out.println(historyList.get(i));
        }
    }
}




