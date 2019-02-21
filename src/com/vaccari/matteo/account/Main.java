package com.vaccari.matteo.account;

import com.vaccari.matteo.account.accounts.CurrentAccount;
import com.vaccari.matteo.account.accounts.SavingAccount;
import com.vaccari.matteo.account.clients.Admin;
import com.vaccari.matteo.account.clients.Client;
import com.vaccari.matteo.account.exceptions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Main {
    public static void main(String... args) throws InterruptedException {

        Bank bank1 = new Bank("Bank1");  //Instanciation de la banque Bank1

        List<String> accountList = new ArrayList<>(); // Liste de comptes


        Client thierry = new Client("Thierry"); //Instanciation de clients
        Client matthieu = new Client("Matthieu");

        Admin guichetiere = new Admin("Guichetiere"); // Instanciation de la guichetière

        thierry.bank = bank1;  //Affectation de la banque à l'attribut des clients
        matthieu.bank = bank1;

        bank1.client = matthieu; // Affection de matthieu comme client // test(X)

        CurrentAccount thierryCurrentAccount = new CurrentAccount("Thierry");   //Creation du compte courant des clients
        CurrentAccount matthieuCurrentAccount = new CurrentAccount("Matthieu");
        SavingAccount matthieuSavingAccount = new SavingAccount("Matthieu");  // Création du compte épargne de Matthieu

        thierry.currentAccount = thierryCurrentAccount;   //Affectation des comptes courants
        matthieu.currentAccount = matthieuCurrentAccount;
        matthieu.savingAccount = matthieuSavingAccount;    // Affectation du compte épargne

        accountList.add(thierryCurrentAccount.name);  // Ajout des comptes à la liste de comptes
        accountList.add(matthieuCurrentAccount.name);
        accountList.add(matthieuSavingAccount.name);

        Scanner sc = new Scanner(System.in);   // Instanciation du scanner



 System.out.println("Admin.");
 System.out.println("Mot de passe ?");
 String inputPassword = sc.nextLine();   // Connection
 while (!inputPassword.equals(guichetiere.getPassWord())) {  //Tant que le mot de passe tapé est différent du getPass, on retry
 System.out.println("Mot de passe Incorrect, réassayez.");
 inputPassword = sc.nextLine();
 }
 System.out.println("Mot de passe correct, accés à l'application autorisé.");  //Si mot de passe entré .equals le mot de passe, accés autorisé


        int nbInfinity = 1;

        while (nbInfinity == 1) {
            bank1.showBankMenu();

            int nbTodo = sc.nextInt();

            switch (nbTodo) {
                case 1:
                    System.out.println("Voici la liste des clients:");

                    Set<Map.Entry<Integer, Client>> setHm = Bank.clientList.entrySet();
                    Iterator<Map.Entry<Integer, Client>> it = setHm.iterator();
                    while (it.hasNext()) {
                        Map.Entry<Integer, Client> e = it.next();
                        System.out.println(e.getKey() + " : " + e.getValue().name);
                    }

                    Thread.sleep(4500);
                 break;
                case 2:
                    System.out.println("Voici la liste des comptes");
                    for (int i = 0; i < accountList.size(); i++) {
                        System.out.println(accountList.get(i));
                    }
                    Thread.sleep(4500);
                    break;
                case 3:
                    System.out.println("Interface des versements, choisir client qui va recevoir le dépôt:");

                    Set<Map.Entry<Integer, Client>> setHm2 = Bank.clientList.entrySet();
                    Iterator<Map.Entry<Integer, Client>> it2 = setHm2.iterator();
                    while (it2.hasNext()) {
                        Map.Entry<Integer, Client> e = it2.next();
                        System.out.println(e.getKey() + " : " + e.getValue().name);
                    }

                    int clientDeposit = sc.nextInt();

                    if (Bank.clientList.containsKey(clientDeposit)) {
                        System.out.println("Choisir la somme à virer sur le compte de " + Bank.clientList.get(clientDeposit).name + " :");
                        int amountDeposit = sc.nextInt();

                        try {
                            Bank.clientList.get(clientDeposit).deposit(amountDeposit,Bank.clientList.get(clientDeposit));
                        } catch (NegativeAmountForDepositException e) {
                            e.printStackTrace();
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Erreur de saisi ID client");
                    }
                    Thread.sleep(4500);
                    break;

                case 4:
                    System.out.println("Interface des retraits");
                    System.out.println("1 - Effectuer un retrait");
                    System.out.println("2 - Retour");

                    int nb6 = sc.nextInt();

                    switch (nb6) {
                        case 1:
                            System.out.println("Interface des retraits, choisir client qui va retirer son argent:");

                            Set<Map.Entry<Integer, Client>> setHm3 = Bank.clientList.entrySet();
                            Iterator<Map.Entry<Integer, Client>> it3 = setHm3.iterator();
                            while (it3.hasNext()) {
                                Map.Entry<Integer, Client> e = it3.next();
                                System.out.println(e.getKey() + " : " + e.getValue().name);
                            }
                            int clientWithdrawal = sc.nextInt();

                            if (Bank.clientList.containsKey(clientWithdrawal)) {
                                System.out.println("Choisir la somme à retirer sur le compte de " + Bank.clientList.get(clientWithdrawal).name);
                                int amountWithDrawal = sc.nextInt();
                                try {                                                                                   //Catch de l'esception pour solde insu pour retrait
                                    Bank.clientList.get(clientWithdrawal).withdrawal(amountWithDrawal, Bank.clientList.get(clientWithdrawal));
                                } catch (InsufisiantBalanceForWithdrawalException | NegativeAmountForWithdrawalException e) {
                                    e.printStackTrace();
                                    System.out.println(e.getMessage());
                                }

                            }
                            Thread.sleep(4500);
                            break;
                        case 2:
                            Thread.sleep(150);
                    }
                    break;

                case 5:
                    System.out.println("Interface des virements");
                    System.out.println("1 - Effectuer un virement");
                    System.out.println("2 - Retour");

                    int nb5 = sc.nextInt();

                    switch(nb5) {
                        case 1:
                            System.out.println("Interface des virements, choisir client émmetteur");

                            Set<Map.Entry<Integer, Client>> setHm4 = Bank.clientList.entrySet();
                            Iterator<Map.Entry<Integer, Client>> it4 = setHm4.iterator();
                            while (it4.hasNext()) {
                                Map.Entry<Integer, Client> e = it4.next();
                                System.out.println(e.getKey() + " : " + e.getValue().name);
                            }
                            int client1 = sc.nextInt();

                            System.out.println("Choisir client recepteur");

                            Set<Map.Entry<Integer, Client>> setHm5 = Bank.clientList.entrySet();
                            Iterator<Map.Entry<Integer, Client>> it5 = setHm4.iterator();
                            while (it5.hasNext()) {
                                Map.Entry<Integer, Client> e2 = it5.next();
                                System.out.println(e2.getKey() + " : " + e2.getValue().name);
                            }
                            int client2 = sc.nextInt();

                            System.out.println("Choisir montant du transfer");
                            int amount = sc.nextInt();

                            if (Bank.clientList.containsKey(client1) && Bank.clientList.containsKey(client2)) {
                                try {
                                    bank1.transfer(Bank.clientList.get(client1), Bank.clientList.get(client2), amount);
                                } catch (InsufisiantBalanceForBankTransferException | NegativeAmountForTransfertException e3) {
                                    e3.printStackTrace();
                                    System.out.println(e3.getMessage());
                                }
                            } else {
                                System.out.println("Erreur de saisie.");
                            }
                            Thread.sleep(4500);
                            break;
                        case 2:
                            Thread.sleep(150);
                    }
                    break;

                case 6:
                    System.out.println("Interface de consultation des soldes:");
                    System.out.println("1 - Consulter un solde");
                    System.out.println("2 - Retour");

                    int nb4 = sc.nextInt();

                    switch (nb4) {
                        case 1:
                            System.out.println("Choisir client à consulter le(s) solde(s)");

                            Set<Map.Entry<Integer, Client>> setHm6 = Bank.clientList.entrySet();
                            Iterator<Map.Entry<Integer, Client>> it6 = setHm6.iterator();
                            while (it6.hasNext()) {
                                Map.Entry<Integer, Client> e2 = it6.next();
                                System.out.println(e2.getKey() + " : " + e2.getValue().name);
                            }

                            int client = sc.nextInt();
                            if (Bank.clientList.containsKey(client)) {
                                Bank.clientList.get(client).showBalance();
                            } else {
                                System.out.println("Erreur de saisie");
                            }

                            Thread.sleep(4500);
                            break;
                        case 2:
                            Thread.sleep(150);
                    }
                    break;

                case 7:
                    System.out.println("Interface de consultation de page Client:");
                    System.out.println("1 - Consulter les informations d'un client");
                    System.out.println("2 - Retour");

                    int nb3 = sc.nextInt();

                    switch(nb3) {
                        case 1:
                            System.out.println("Choisir client à consulter les informations :");

                            Set<Map.Entry<Integer, Client>> setHm7 = Bank.clientList.entrySet();
                            Iterator<Map.Entry<Integer, Client>> it7 = setHm7.iterator();
                            while (it7.hasNext()) {
                                Map.Entry<Integer, Client> e2 = it7.next();
                                System.out.println(e2.getKey() + " : " + e2.getValue().name);
                            }

                            int clientInfo = sc.nextInt();

                            if(Bank.clientList.containsKey(clientInfo)) {
                                Bank.clientList.get(clientInfo).showInfo();
                            } else {
                                System.out.println("Erreur de saisie");
                            }

                            Thread.sleep(4500);
                            break;
                        case 2:
                            Thread.sleep(150);
                    }
                    break;
                case 8:
                    bank1.showTransferHistory();
                    Thread.sleep(4500);
                    break;
                case 9:
                    bank1.showHistory();
                    Thread.sleep(4500);
                    break;
                case 10:
                    System.out.println("Interface de création de clients");
                    System.out.println("1 - Créer un client");
                    System.out.println("2 - Retour");

                    int nb = sc.nextInt();

                      switch(nb) {
                          case 1:
                              System.out.println("Entrez le nom du client:");
                              sc.nextLine();
                              String clientName = sc.nextLine();
                              new Client (clientName);
                              System.out.println("Client crée.");
                              accountList.add("Compte courant de " + clientName);
                              Thread.sleep(4000);
                              break;
                          case 2:
                              Thread.sleep(150);
                      }
                    break;
                case 11:
                    System.out.println("Interface de suppréssion de client");
                    System.out.println("1 - Supprimer un client");
                    System.out.println("2 - Retour");

                    int nb2 = sc.nextInt();

                    switch (nb2) {
                        case 1:
                            System.out.println("Choisir l'ID du client à supprimer :");
                            Set<Map.Entry<Integer, Client>> setHm8 = Bank.clientList.entrySet();
                            Iterator<Map.Entry<Integer, Client>> it8 = setHm8.iterator();
                            while (it8.hasNext()) {
                                Map.Entry<Integer, Client> e2 = it8.next();
                                System.out.println(e2.getKey() + " : " + e2.getValue().name);
                            }
                            int nbRemove = sc.nextInt();
                            Bank.clientList.remove(nbRemove);
                            System.out.println("Client supprimé avec succès.");
                            Thread.sleep(4500);
                            break;
                        case 2:
                            Thread.sleep(150);
                            break;
                    }
            }
        }
        System.out.println(" "); // avant retour du menu ligne blanche
    }
}


