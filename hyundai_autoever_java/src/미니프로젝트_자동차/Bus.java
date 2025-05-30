package 미니프로젝트_자동차;

import 다형성.Vehicle;

public class Bus extends Car implements Aircon, AutoDrive {
    public Bus() {
        super(150, 5, 100, 20, "관광 버스");
    }

    public void setMode(boolean func) {
        if (func) {
            feul += 30;
        }
    }

    @Override
    public String airconInfo() {
        return "에어컨 ON";
    }

    @Override
    public String autoDriveInfo() {
        return "자율주행 ON";
    }
}
