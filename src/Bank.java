import java.util.ArrayList;
import java.util.List;

public class Bank {
    // Attributs
    String name;
    int capital = 100000;
    List<String> transferHistory = new ArrayList<>();

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
}
