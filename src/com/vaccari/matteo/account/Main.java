package com.vaccari.matteo.account;

import com.vaccari.matteo.account.accounts.CurrentAccount;
import com.vaccari.matteo.account.accounts.SavingAccount;
import com.vaccari.matteo.account.clients.Admin;
import com.vaccari.matteo.account.clients.Client;
import com.vaccari.matteo.account.exceptions.*;

import java.util.*;

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

                    Set<Map.Entry<Integer, String>> setHm = Client.clientList.entrySet();
                    Iterator<Map.Entry<Integer, String>> it = setHm.iterator();
                    while (it.hasNext()) {
                        Map.Entry<Integer, String> e = it.next();
                        System.out.println(e.getKey() + " : " + e.getValue());
                    }

                    Thread.sleep(4500);
                    break;
                case 2:
                    System.out.println("Voici la liste des comptes");
                    /* X*/
                    for (int i = 0; i < accountList.size(); i++) {
                        System.out.println(accountList.get(i));
                    }
                    Thread.sleep(4500);
                    break;
                case 3:
                    System.out.println("Interface des versements, choisir client qui va recevoir le dépôt:");

                    Set<Map.Entry<Integer, String>> setHm2 = Client.clientList.entrySet();
                    Iterator<Map.Entry<Integer, String>> it2 = setHm2.iterator();
                    while (it2.hasNext()) {
                        Map.Entry<Integer, String> e = it2.next();
                        System.out.println(e.getKey() + " : " + e.getValue());
                    }

                    int clientDeposit = sc.nextInt();

                    if (Client.clientList.containsKey(clientDeposit)) {
                        System.out.println("Choisir la somme à virer sur le compte de " + Client.clientList.get(clientDeposit) + " :");
                        int amountDeposit = sc.nextInt();

                        try {
                            /* X*/                       Client.clientList.get(clientDeposit).deposit(amountDeposit);
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
                    System.out.println("Interface des retraits, choisir client qui va retirer son argent:");

                    Set<Map.Entry<Integer, String>> setHm3 = Client.clientList.entrySet();
                    Iterator<Map.Entry<Integer, String>> it3 = setHm3.iterator();
                    while (it3.hasNext()) {
                        Map.Entry<Integer, String> e = it3.next();
                        System.out.println(e.getKey() + " : " + e.getValue());
                    }
                    int clientWithdrawal = sc.nextInt();

                    if (Client.clientList.containsKey(clientWithdrawal)) {
                        System.out.println("Choisir la somme à retirer sur le compte de " + Client.clientList.get(clientWithdrawal));
                        int amountWithDrawal = sc.nextInt();
                        try {                                                                                   //Catch de l'esception pour solde insu pour retrait
                            /* X */                       .withdrawal(amountWithDrawal);
                        } catch (InsufisiantBalanceForWithdrawalException | NegativeAmountForWithdrawalException e) {
                            e.printStackTrace();
                            System.out.println(e.getMessage());
                        }

                    }
                    Thread.sleep(4500);
                    break;
                case 5:
                    System.out.println("Interface des virements, choisir client émmetteur");

                    Set<Map.Entry<Integer, String>> setHm4 = Client.clientList.entrySet();
                    Iterator<Map.Entry<Integer, String>> it4 = setHm3.iterator();
                    while (it4.hasNext()) {
                        Map.Entry<Integer, String> e = it4.next();
                        System.out.println(e.getKey() + " : " + e.getValue());
                    }
                        int client1 = sc.nextInt();

                        System.out.println("Choisir client recepteur");

                        Set<Map.Entry<Integer, String>> setHm5 = Client.clientList.entrySet();
                        Iterator<Map.Entry<Integer, String>> it5 = setHm3.iterator();
                        while (it5.hasNext()) {
                            Map.Entry<Integer, String> e2 = it5.next();
                            System.out.println(e2.getKey() + " : " + e2.getValue());
                        }
                            int client2 = sc.nextInt();

                            System.out.println("Choisir montant du transfer");
                            int amount = sc.nextInt();

                            if (Client.clientList.containsKey(client1) && Client.clientList.containsKey(client2)) {
                                try {
      /*    X*/                   .transfer(client1, client2, amount);
                                } catch (InsufisiantBalanceForBankTransferException | NegativeAmountForTransfertException e3) {
                                    e3.printStackTrace();
                                    System.out.println(e3.getMessage());
                                }
                            } else {
                                System.out.println("Erreur de saisie.");
                            }
                            Thread.sleep(4500);
                            break;
                            case 6:
                                System.out.println("Choisir client à consulter le(s) solde(s)");
                                System.out.println("1 - Thierry");
                                System.out.println("2 - Matthieu");

                                int client = sc.nextInt();

                                if (client == 1) {
                                    thierry.showBalance();
                                } else if (client == 2) {
                                    matthieu.showBalance();
                                }
                                Thread.sleep(4500);
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
                                Thread.sleep(4500);
                                break;
                            case 8:
                                bank1.showTransferHistory();
                                Thread.sleep(4500);
                                break;
                            case 9:

                        }
                        }
                        System.out.println(" "); // avant retour du menu ligne blanche
                    }
            }



