package 에어컨설계;

public class DefaultAircon {
    private String power;
    private int presentTemp;
    private int settingTemp;
    private int windPower;

    public DefaultAircon(String power, int presentTemp, int settingTemp, int windPower) {
        this.power = power;
        this.presentTemp = presentTemp;
        this.settingTemp = settingTemp;
        this.windPower = windPower;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public int getPresentTemp() {
        return presentTemp;
    }

    public void setPresentTemp(int presentTemp) {
        this.presentTemp = presentTemp;
    }

    public int getSettingTemp() {
        return settingTemp;
    }

    public void setSettingTemp(int settingTemp) {
        this.settingTemp = settingTemp;
    }

    public int getWindPower() {
        return windPower;
    }

    public void setWindPower(int windPower) {
        this.windPower = windPower;
    }

    public void viewAircon() {
        System.out.println("전원 상태 : " + getPower());
        System.out.println("현재 온도 : " + getPresentTemp());
        System.out.println("설정 온도 : " + getSettingTemp());
        System.out.println("바람 세기 : " + getWindPower());
    }
}
