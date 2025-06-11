public class AquariumFish {
    private String name;
    private double minTemp;
    private double maxTemp;

    public AquariumFish(String name, double minTemp, double maxTemp) {
        this.name = name;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public double calculateAverageTemp() {
        return (minTemp + maxTemp) / 2;
    }
}
