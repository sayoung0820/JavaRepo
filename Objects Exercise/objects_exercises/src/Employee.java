public class Employee {
    String name;
    static int totalEmployees = 0;

    // Create constructor
    public Employee(String name) {
        this.name = name;
        totalEmployees++;
    }

}
