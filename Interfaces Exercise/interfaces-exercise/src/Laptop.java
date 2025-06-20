
public class Laptop implements ApplianceStates {

    @Override
    public void turnOn() {
        isOn = true;
    }

    @Override
    public void turnOff() {
        isOff = true;
    }

    @Override
    public String getDeviceName() {
        return "laptop";
    }

    @Override
    public Boolean isOn() {
        return laptop;
    }
}
