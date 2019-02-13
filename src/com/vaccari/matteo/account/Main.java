package com.vaccari.matteo.account;

import com.vaccari.matteo.account.accounts.CurrentAccount;
import com.vaccari.matteo.account.accounts.SavingAccount;
import com.vaccari.matteo.account.clients.Admin;
import com.vaccari.matteo.account.clients.Client;
import com.vaccari.matteo.account.exceptions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String... args) throws InterruptedException {

        Bank bank1 = new Bank("Bank1");  //Instanciation de la banque Bank1

        List<String> clientList = new ArrayList<>(); // Liste des clients
        List<String> accountList = new ArrayList<>(); // Liste de comptes

        Client thierry = new Client("Thierry"); //Instanciation de clients
        Client matthieu = new Client("Matthieu");

        Admin guichetiere = new Admin("Guichetiere"); // Instanciation de la guichetière

        clientList.add(thierry.name);    // Ajout des clients à la liste de clients
        clientList.add(matthieu.name);

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


/**
        System.out.println("Admin.");
        System.out.println("Mot de passe ?");

        String inputPassword = sc.nextLine();   // Connection

        while (!inputPassword.equals(guichetiere.getPassWord())) {  //Tant que le mot de passe tapé est différent du getPass, on retry
            System.out.println("Mot de passe Incorrect, réassayez.");
            inputPassword = sc.nextLine();
        }
        System.out.println("Mot de passe correct, accés à l'application autorisé.");  //Si mot de passe entré .equals le mot de passe, accés autorisé
            */

        int nbInfinity = 1;

        while (nbInfinity == 1) {
            bank1.showBankMenu();

            int nbTodo = sc.nextInt();

            switch (nbTodo) {
                case 1:
                    System.out.println("Voici la liste des clients:");
                    for (int i = 0; i < clientList.size(); i++) {
                        System.out.println(clientList.get(i));
                    }
                    Thread.sleep(3000);
                    break;
                case 2:
                    System.out.println("Voici la liste des comptes");
                    for (int i = 0; i < accountList.size(); i++) {
                        System.out.println(accountList.get(i));
                    }
                    Thread.sleep(3000);
                    break;
                case 3:
                    System.out.println("Interface des versements, choisir client qui va recevoir le dépôt:");
                    for (int i = 0; i < clientList.size(); i++) {
                        System.out.println(clientList.get(i));
                        String clientDeposit = sc.nextLine();

                        if (clientDeposit.equalsIgnoreCase("thierry")) {
                            System.out.println("Choisir la somme à virer sur le compte de Thierry: ");
                            int amountDeposit = sc.nextInt();
                                try {
                                    thierry.deposit(amountDeposit, thierryCurrentAccount);
                                } catch (NegativeAmountForDepositException e) {
                                }
                        } else if (clientDeposit.equalsIgnoreCase("matthieu")) {
                            System.out.println("Choisir la somme à virer sur le compte de Matthieu: ");
                            int amountDeposit2 = sc.nextInt();
                                try {
                                    matthieu.deposit(amountDeposit2, matthieuCurrentAccount);
                                } catch (NegativeAmountForDepositException e) {
                                }
                        }
                    }
                     Thread.sleep(3001);
                    break;

                case 4:
                    System.out.println("Interface des retraits, choisir client qui va retirer son argent:");
                    for (int i = 0; i < clientList.size(); i++) {
                        System.out.println(clientList.get(i));
                        String clientWithdrawal = sc.nextLine();

                        if (clientWithdrawal.equalsIgnoreCase("thierry")) {
                            System.out.println("Choisir la somme à retirer sur le compte de Thierry: ");
                            int amountWithDrawal = sc.nextInt();
                            try {                                                                                   //Catch de l'esception pour solde insu pour retrait
                                thierry.withdrawal(amountWithDrawal, thierryCurrentAccount);
                            }
                            catch (InsufisiantBalanceForWithdrawalException | NegativeAmountForWithdrawalException e) {

                            }

                        } else if (clientWithdrawal.equalsIgnoreCase("matthieu")) {
                            System.out.println("Choisir la somme à retirer sur le compte de Matthieu: ");
                            int amountWithDrawal = sc.nextInt();
                            try {                                                                                   //Catch de l'esception pour solde insu pour retrait
                                matthieu.withdrawal(amountWithDrawal, matthieuCurrentAccount);
                            }
                            catch (InsufisiantBalanceForWithdrawalException | NegativeAmountForWithdrawalException e){

                            }

                        }
                    }
                    Thread.sleep(3000);
                    break;
                case 5:
                    System.out.println("Interface des virements, choisir client émmetteur");

                    System.out.println("1 - Matthieu");
                    System.out.println("2 - Thierry");
                    int client1 = sc.nextInt();

                    System.out.println("Choisir client recepteur");

                    System.out.println("1 - Matthieu");
                    System.out.println("2 - Thierry");
                    int client2 = sc.nextInt();

                    System.out.println("Choisir montant du transfer");
                    int amount = sc.nextInt();


                        if (client1 == 1 && client2 == 1) {
                            System.out.println("Virement impossible entre deux comptes du même client, réassayez");   // Exception à créer
                        }

                        else if (client1 == 1 && client2 == 2) {

                            try {                                                                                                   // Catch des 2 exceptions solde insu ou montant négatif
                                bank1.transfer(matthieu, thierry, amount);
                            }
                                 catch (NegativeAmountForTransfertException | InsufisiantBalanceForBankTransferException e) {
                                  }
                            }


                        else if (client1 == 2 && client2 == 2) {
                            System.out.println("Virement impossible entre deux comptes du même client, réassayez");
                        } else if (client1 == 2 && client2 == 1) {
                            try {                                                                                        // Catch des 2 exceptions solde insu ou montant négatif
                                bank1.transfer(thierry,matthieu,amount);
                            }
                            catch (NegativeAmountForTransfertException | InsufisiantBalanceForBankTransferException e) {

                            }
                        }
                        else {
                            System.out.println("Erreur de saisie.");
                        }
                    Thread.sleep(3000);
                    break;
                case 6 :
                    System.out.println("Choisir client à consulter le(s) solde(s)");
                    System.out.println("1 - Thierry");
                    System.out.println("2 - Matthieu");

                    int client = sc.nextInt();

                        if (client == 1) {
                            thierry.showBalance();
                        } else if (client == 2) {
                            matthieu.showBalance();
                        }
                    Thread.sleep(3000);
                    break;
                case 7:
                    System.out.println("Choisir client à consulter les informations :");
                    System.out.println("1 - Thierry");
                    System.out.println("2 - Matthieu");

                    int clientInfo = sc.nextInt();

                    if (clientInfo == 1) {
                        thierry.showInfo();
                    } else if (clientInfo == 2) {
                        matthieu.showInfo();
                    }
                    Thread.sleep(3000);
                    break;
                case 8:
                    bank1.showTransferHistory();
                    Thread.sleep(3000);
                    break;
                case 9:
                    System.out.println(bank1.createClient("Charles"));


                    for (int i = 0; i < clientList.size();i++){
                        System.out.println(clientList.get(i));
                    }

            }
            System.out.println(" "); // avant retour du menu ligne blanche
        }
    }
}
