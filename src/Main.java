import java.util.ArrayList;

//Library management
class Book {
    String title, author;
    Book(String t, String a) { this.title = t; this.author = a; }
    void getFormat() { System.out.println("Generic book format"); }
}

class EBook extends Book {
    EBook(String t, String a) { super(t, a); }
    @Override void getFormat() { System.out.println("Digital format"); }
}

class PrintedBook extends Book {
    PrintedBook(String t, String a) { super(t, a); }
    @Override void getFormat() { System.out.println("Paper format"); }
}

//Game characters
class Character {
    void attack() { System.out.println("Character attacks"); }
    void defend() { System.out.println("Character defends"); }
}

class Warrior extends Character {
    @Override void attack() { System.out.println("Warrior swings sword"); }
}

class Mage extends Character {
    @Override void attack() { System.out.println("Mage casts fireball"); }
}

class Archer extends Character {
    @Override void attack() { System.out.println("Archer shoots arrow"); }
}

//Banking system
class Account {
    double balance;
    Account(double balance) { this.balance = balance; }
    void deposit(double amount) { balance += amount; }
    void withdraw(double amount) { balance -= amount; }
}

class SavingsAccount extends Account {
    SavingsAccount(double b) { super(b); }
    @Override
    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Savings Error: Insufficient funds!");
        }
    }
}

class CheckingAccount extends Account {
    CheckingAccount(double b) { super(b); }
    // No check needed here; balance can go negative (overdraft)
}

public class Main {
    public static void main(String[] args) {

        System.out.println("library");
        ArrayList<Book> library = new ArrayList<>();
        library.add(new EBook("Java 101", "AI Guru"));
        library.add(new PrintedBook("Old School Coding", "Classic Author"));
        for (Book b : library) {
            System.out.print(b.title + " format: ");
            b.getFormat();
        }

        System.out.println("\n game characters");
        ArrayList<Character> party = new ArrayList<>();
        party.add(new Warrior());
        party.add(new Mage());
        party.add(new Archer());
        for (Character c : party) {
            c.attack();
            c.defend();
        }

        System.out.println("\nbanking system");
        SavingsAccount savings = new SavingsAccount(100);
        CheckingAccount checking = new CheckingAccount(100);

        savings.withdraw(150); // Should fail
        checking.withdraw(150); // Should allow (overdraft)

        System.out.println("Savings Balance: $" + savings.balance);
        System.out.println("Checking Balance: $" + checking.balance);

    }
}
