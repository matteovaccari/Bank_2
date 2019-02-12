package Bank.account;

import Bank.clients.Client;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    // Attributs
    public String name;
    int capital = 100000;
    public List<String> transferHistory = new ArrayList<>();
    public Client client;

    // Constructeur

   public Bank  (String name) {
        this.name = name;
    }

    // Méthodes

   public void transfer (Client client1, Client client2, int amount) {
        if (client1.currentAccount.balance >= amount) {
            client1.currentAccount.balance -= amount;
            client2.currentAccount.balance += amount;
            System.out.println(amount + "€ on étés transférés du compte de " + client1.name + " au compte de " + client2.name + ".");
            transferHistory.add("Virement entre " + client1.name + " et " + client2.name + " de : " + amount + "€.");
        } else if (client1.currentAccount.balance < amount) {
            System.out.println("Le transfert de " + amount + "€ entre les comptes de "+ client1.name + " et " + client2.name +
                    " est impossible, pour cause de solde insufisant.");
        } else {
            System.out.println("Erreur de saisie, compte client inéxistant ou montant incorrect");
        }

         // Il n'est pas possible de virer de l'argent vers/depuis un compte épargne d'un autre client, seul ce dernier le peut.


    }

   public void showTransferHistory () {
        if (transferHistory.size() != 0) {
            System.out.println("Voici la liste des transfers qui ont eut lieu dans " + this.name);
            for (int i = 0; i < transferHistory.size(); i++) {
                System.out.println(transferHistory.get(i));
            }
        } else if (transferHistory.size() == 0) {
            System.out.println("Aucune transaction réalisée");
        }
    }
   public void showBankMenu() {
        System.out.println("Que voulez vous faire ?:");
        System.out.println("1 - Voir la liste des clients");
        System.out.println("2 - Voir la liste des comptes");
        System.out.println("3 - Effectuer un versement");
        System.out.println("4 - Effectuer un retrait");
        System.out.println("5 - Effectuer un virement entre deux clients");
        System.out.println("6 - Voir le solde des comptes d'un client");
        System.out.println("7 - Voir les informations d'un client");
        System.out.println("8 - Voir l'historique des transactions");
    }

}
