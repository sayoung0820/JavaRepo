public class ObjectPractice {

    public static void main(String[] args) {
        // Create Car object
        Car car1 = new Car("Toyota", "Corolla", 2020);
        Car car2 = new Car("Ford", "Mustang", 2022);

        // Print out 1st car info
        System.out.print("Car 1: ");
        car1.displayInfo();
        // Print out 2nd car info
        System.out.print("Car 2: ");
        car2.displayInfo();

        // Create book objects
        System.out.println();
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", true);
        Book book2 = new Book("My Soul to Keep", "Tananarive Due", true);

        // Print book availability before borrowing
//        System.out.println("Before borrowing...");
        book1.displayInfo();
//        System.out.println("Before borrowing...");
        book2.displayInfo();

        // Borrow the book
        System.out.println("Borrowing the book...");
        book1.borrowBook();
//        System.out.println("Borrowing the book... ");
        book2.borrowBook();

        // After borrowing the book
//        System.out.println("After borrowing the book:  ");
        book1.displayInfo();
//        System.out.println("After borrowing the book:  ");
        book2.displayInfo();

        // Create bank account object
        System.out.println();
        BankAccount acc1 = new BankAccount("Alice", 1000.0);
        BankAccount acc2 = acc1;
        acc1.displayBalance();
        System.out.println("Initial Balance (acc 1): $" + acc1.balance);
        System.out.println("Depositing $500 to acc2...");
        acc2.deposit(500.0);
        System.out.println("Updated Balance (acc1): $" + acc1.balance);
//        acc1.displayBalance();

        // Create Employee Object
        System.out.println();
        new Employee("John");
        new Employee("Jane");
        new Employee("Mike");
        System.out.println("Total Employees: " + Employee.totalEmployees);

    }
}
