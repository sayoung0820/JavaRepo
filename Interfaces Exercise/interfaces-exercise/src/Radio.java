
public class Radio implements ApplianceStates {

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
        return "radio";
    }

    @Override
    public Boolean isOn() {
        return isOn;
    }
}
