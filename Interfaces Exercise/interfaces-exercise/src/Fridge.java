
public class Fridge implements ApplianceStates {

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
        return "";
    }

    @Override
    public Boolean isOn() {
        return fridge;
    }
}
