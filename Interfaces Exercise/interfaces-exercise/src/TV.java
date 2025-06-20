

public class TV implements ApplianceStates {

    @Override
    public void turnOn() {
        isOn = true ;

    }

    @Override
    public void turnOff() {
        isOff = true;

    }

    @Override
    public String getDeviceName() {
        return "TV";
    }

    @Override
    public Boolean isOn() {
        return isOn;
    }
}
