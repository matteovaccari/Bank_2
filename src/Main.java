import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String... args) {

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



         System.out.println("Admin.");
         System.out.println("Mot de passe ?");

         String inputPassword = sc.nextLine();   // Connection

         while (!inputPassword.equals(guichetiere.getPassWord())) {  //Tant que le mot de passe tapé est différent du getPass, on retry
         System.out.println("Mot de passe Incorrect, réassayez.");
         inputPassword = sc.nextLine();
         }
         System.out.println("Mot de passe correct, accés à l'application autorisé.");  //Si mot de passe entré .equals le mot de passe, accés autorisé


        int nbInfinity = 1;

        while (nbInfinity ==1) {
            bank1.showBankMenu();

            int nbTodo = sc.nextInt();

            switch (nbTodo) {
                case 1:
                    System.out.println("Voici la liste des clients:");
                    for (int i = 0; i < clientList.size(); i++) {
                        System.out.println(clientList.get(i));
                    }
                    break;
                case 2:
                    System.out.println("Voici la liste des comptes");
                    for (int i = 0; i < accountList.size(); i++) {
                        System.out.println(accountList.get(i));
                    }
                    break;
                case 3:
                    System.out.println("Interface des versements, choisir client qui va recevoir le dépôt:");
                    for (int i = 0; i < clientList.size(); i++) {
                        System.out.println(clientList.get(i));
                        String clientDeposit = sc.nextLine();

                        if (clientDeposit.equalsIgnoreCase("thierry")) {
                            System.out.println("Choisir la somme à virer sur le compte de Thierry: ");
                            int amountDeposit = sc.nextInt();
                            thierry.deposit(amountDeposit, thierryCurrentAccount);

                        } else if (clientDeposit.equalsIgnoreCase("matthieu")) {
                            System.out.println("Choisir la somme à virer sur le compte de Matthieu: ");
                            int amountDeposit2 = sc.nextInt();
                            matthieu.deposit(amountDeposit2, matthieuCurrentAccount);
                        } /** else {
                            System.out.println("Erreur de saisie nom client, réassayez.");
                        }   */
                    }
                    break;

                case 4:
                    System.out.println("Interface des retraits, choisir client qui va retirer son argent:");
                    for (int i = 0; i < clientList.size(); i++) {
                        System.out.println(clientList.get(i));
                        String clientWithdrawal = sc.nextLine();

                        if (clientWithdrawal.equalsIgnoreCase("thierry")) {
                            System.out.println("Choisir la somme à retirer sur le compte de Thierry: ");
                            int amountWithDrawal = sc.nextInt();
                            thierry.withdrawal(amountWithDrawal, thierryCurrentAccount);

                        } else if (clientWithdrawal.equalsIgnoreCase("matthieu")) {
                            System.out.println("Choisir la somme à retirer sur le compte de Matthieu: ");
                            int amountWithDrawal = sc.nextInt();
                            matthieu.withdrawal(amountWithDrawal, matthieuCurrentAccount);
                        } /** else {
                         System.out.println("Erreur de saisie nom client, réassayez.");
                         }   */
                    }
                    break;

            }
            System.out.println(" "); // avant retour du menu ligne blanche
        }


        }



    }
