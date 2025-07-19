public class Main {
    public static void main(String[] args) {


        Plant plant1 = new Plant("Ivy", 5.11);
        Plant plant2 = new Plant("Pothos", 4.25);

        plant1.describe();
        plant2.describe();

        plant1.setHeight(6.5);
        plant1.setName("Spider Plant");

        plant1.describe();

        Plant plant3 = new Plant("Plant 3", 0.0);
        Plant plant4 = new Plant("Plant 4", 0.0);
        Plant plant5 = new Plant("Plant 5", 0.0);

        plant3.setName("Fern");
        plant3.setHeight(7.3);

        plant4.setName("Bamboo");
        plant4.setHeight(12.8);

        plant5.setName("Succulent");
        plant5.setHeight(3.5);

        plant3.describe();
        plant4.describe();
        plant5.describe();


    }
}
