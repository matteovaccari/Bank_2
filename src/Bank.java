import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    // Attributs
    String name;
    int capital = 100000;
    List<String> transferHistory = new ArrayList<>();
    Client client;

    // Constructeur

    Bank  (String name) {
        this.name = name;
    }

    // Méthodes

    void transfer (Client client1, Client client2, int amount) {
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

    void showTransferHistory () {
        System.out.println("Voici la liste des transfers qui ont eut lieu dans " + this.name);
        for (int i = 0; i < transferHistory.size(); i++) {
            System.out.println(transferHistory.get(i));
        }
    }

    void showBankMenu() {
        System.out.println("Bienvenu guichetière, que voulez vous faire ?:");
        System.out.println("1 - Voir la liste des clients");
        System.out.println("2 - Voir la liste des comptes");
        System.out.println("3 - Effectuer un versement");
        System.out.println("4 - Effectuer un retrait");
        System.out.println("5 - Effectuer un virement entre deux clients");
        Scanner sc = new Scanner(System.in);
        String nbTodo = sc.nextLine();
        while (nbTodo != "1" || nbTodo != "2"|| nbTodo != "3"|| nbTodo != "4"|| nbTodo != "5") {
            System.out.println("Erreur de saisie, entrez le numéro correspondant à une action");
        }
        switch (nbTodo) {
            case "1":
                System.out.println();
        }
    }
}
