public class BankAccount {
    String owner;
    double balance;

    // Create constructor
    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    // Create deposit method
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to display balance
    public void displayBalance() {
        System.out.println("Owner: " + owner + " | Balance: $" + balance);
    }
}
