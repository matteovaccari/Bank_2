package com.vaccari.matteo.account;

import com.vaccari.matteo.account.accounts.Account;
import com.vaccari.matteo.account.clients.Client;
import com.vaccari.matteo.account.exceptions.InsufisiantBalanceForBankTransferException;
import com.vaccari.matteo.account.exceptions.NegativeAmountForTransfertException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    // Attributs
    public String name;
    int capital = 100000;
    public List<String> transferHistory = new ArrayList<>();
    public Client client;
    public static Map<Integer, Client> clientList = new HashMap<>();
    public static List<String> historyList = new ArrayList<>();

    // Constructeur

   public Bank  (String name) {
        this.name = name;
    }

    // Méthodes

   public void transfer (Client client1, Client client2, int amount) throws InsufisiantBalanceForBankTransferException, NegativeAmountForTransfertException {

                if (client1.currentAccount.balance < amount) {
                    throw new InsufisiantBalanceForBankTransferException("insufisiant balance not allowed for transfers.");   // Créer une exception si le solde du client émétteur est insufissant
                }

                if(amount < 0) {
                    throw new NegativeAmountForTransfertException("Negative amount not allowed for transfers"); // Throw une exception si le montant est négatif
                }

        if (client1.currentAccount.balance >= amount) {
            client1.currentAccount.balance -= amount;
            client2.currentAccount.balance += amount;
            System.out.println(amount + "€ on étés transférés du compte de " + client1.name + " au compte de " + client2.name + ".");
            transferHistory.add("Virement entre " + client1.name + " et " + client2.name + " de : " + amount + "€.");
        }  else {
            System.out.println("Erreur de saisie, compte client inéxistant ou montant incorrect");
        }
        // Il n'est pas possible de virer de l'argent vers/depuis un compte épargne d'un autre client, seul ce dernier le peut.
    }

   public void showTransferHistory () {
        if (!transferHistory.isEmpty()) {
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
        System.out.println("9 - Voir l'historique des dépots/retraits");
    }

   public void addClientToList(int clientID, Client client) {
       clientList.put(clientID, client);
   }

   public static void addDepositToHistoryList (int howMuch, Client client) {
       historyList.add("Dépot de " + howMuch + "€ sur le compte courant de " +  client.name +".");
   }

   public static void addWithDrawalToHistoryList (int howMuch, Client client) {
       historyList.add ("Retrait de " + howMuch + "€ sur le compte courant " +  client.name +".");
   }

    public void showHistory() {
       if(historyList.isEmpty()) {
           System.out.println("Aucun dépot/retrait réalisé.");
       } else {
           System.out.println("Voici l'historique des dépots/retraits :");
           for (int i = 0; i < historyList.size(); i++) {
               System.out.println(historyList.get(i));
           }
       }

    }
   /* public Client createClient(String name) {
       return new Client (name);
    } */

}
