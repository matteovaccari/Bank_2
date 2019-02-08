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


        clientList.add(thierry.name);    // Ajout des clients à la liste de clients
        clientList.add(matthieu.name);

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

        Scanner sc = new Scanner(System.in);   // Instanciation du scanner

        System.out.println("Admin.");
        System.out.println("Mot de passe ?");

        String inputPassword = sc.nextLine();   // Connection

        while (!inputPassword.equals(guichetiere.getPassWord())) {  //Tant que le mot de passe tapé est différent du getPass, on retry
            System.out.println("Mot de passe Incorrect, réassayez.");
            inputPassword = sc.nextLine();
        }
        System.out.println("Mot de passe correct, accés à l'application autorisé.");  //Si mot de passe entré .equals le mot de passe, accés autorisé




    }
}
/**  System.out.println("Voici la liste des clients :");  // Boucle d'affichage de la liste des clients
 for (int i =0; i < clientList.size();i++) {
 System.out.println(clientList.get(i));
 }

 System.out.println("Voici la liste des comptes: ");   //boucle list des comptes
 for (int i = 0; i < accountList.size(); i++) {
 System.out.println( accountList.get(i));
 } */