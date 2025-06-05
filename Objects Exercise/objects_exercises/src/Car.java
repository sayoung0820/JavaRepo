public class Car {
    private String brand;
    private String model;
    private int year;

    // Create Constructor
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Print car data
    public void displayInfo() {
        System.out.println(brand + " " + model + " (" + year + ")");
    }
}
