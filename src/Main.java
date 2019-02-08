import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main (String ... args){

        Bank bank1 = new Bank("Bank1");  //Instanciation de la banque Bank1

        List<String> clientList = new ArrayList<>(); // Liste des clients
        List<String> accountList = new ArrayList<>(); // Liste de comptes

        Client thierry = new Client("Thierry"); //Instanciation de clients
        Client matthieu = new Client ("Matthieu");

        Admin guichetiere = new Admin("Guichetiere"); // Instanciation de la guichetière

        Scanner sc = new Scanner(System.in);   // Instanciation du scanner

        System.out.println("Admin.");
        System.out.println("Mot de passe ?");

        String inputPassword = sc.nextLine();   // Connection

        if (inputPassword.equals(guichetiere.getPassWord())) {
            System.out.println("Mot de passe corect. Accès à l'application accepté.");

        clientList.add(thierry.name);    // Ajout des clients à la liste de clients
        clientList.add(matthieu.name);

        System.out.println("Voici la liste des clients :");  // Boucle d'affichage de la liste des clients
        for (int i =0; i < clientList.size();i++) {
            System.out.println(clientList.get(i));
        }

        thierry.bank = bank1;  //Affectation de la banque à l'attribut des clients
        matthieu.bank = bank1;

        CurrentAccount thierryCurrentAccount = new CurrentAccount("Thierry");   //Creation du compte courant des clients
        CurrentAccount matthieuCurrentAccount = new CurrentAccount("Matthieu");
        SavingAccount matthieuSavingAccount = new SavingAccount("Matthieu");  // Création du compte épargne de Matthieu

        thierry.currentAccount = thierryCurrentAccount;   //Affectation des comptes courants
        matthieu.currentAccount = matthieuCurrentAccount;
        matthieu.savingAccount = matthieuSavingAccount;    // Affectation du compte épargne

        accountList.add(thierryCurrentAccount.name);  // Ajout des comptes à la liste de comptes
        accountList.add(matthieuCurrentAccount.name);
        accountList.add(matthieuSavingAccount.name);

        System.out.println("Voici la liste des comptes: ");
        for (int i = 0; i < accountList.size(); i++) {
            System.out.println( accountList.get(i));
        }

        thierryCurrentAccount.balance = 50;   //Ajout de 50€ sur le solde du compte courant

        thierry.showBalance(thierryCurrentAccount);

        bank1.transfer(thierry,matthieu,25);    // Virement entre le compte de thierry et le compte de matthieu de 2500€

        thierry.showBalance(thierryCurrentAccount);

        thierry.deposit(80,thierryCurrentAccount);
        matthieu.deposit(100,matthieuCurrentAccount);

        thierry.showBalance(thierryCurrentAccount);

        thierry.withdrawal(110,thierryCurrentAccount);

       thierry.showInfo(thierryCurrentAccount);

       matthieu.deposit(150,matthieuSavingAccount);
       matthieu.withdrawal(500,matthieuSavingAccount);

       thierry.showAccounts();
       matthieu.showAccounts();

        bank1.showTransferHistory();

        } else {     // Si le mot de passe est incorrect rien du code ci dessus ne n'éxécute
            System.out.println("Mot de passe inccrrect");
        }

    }
}
