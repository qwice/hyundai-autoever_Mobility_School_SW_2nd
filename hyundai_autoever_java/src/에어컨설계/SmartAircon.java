package 에어컨설계;

public class SmartAircon extends DefaultAircon {
    public SmartAircon(String power) {
        super(power,
                power.equals("on") ? 20 : 0,
                power.equals("on") ? 20 : 0,
                power.equals("on") ? 2 : 0);
    }
}
