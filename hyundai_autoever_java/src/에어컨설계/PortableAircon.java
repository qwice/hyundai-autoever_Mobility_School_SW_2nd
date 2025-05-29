package 에어컨설계;

public class PortableAircon extends DefaultAircon{
    int battery;
    public PortableAircon(String power, int presentTemp, int settingTemp, int windPowr, int battery) {
        super(power, presentTemp, settingTemp, windPowr);
        this.battery = battery;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public void viewAircon() {
        System.out.println("전원 상태 : " + getPower());
        System.out.println("현재 온도 : " + getPresentTemp());
        System.out.println("설정 온도 : " + getSettingTemp());
        System.out.println("바람 세기 : " + getWindPower());
        System.out.println("남은 배터리 : " + getBattery());
    }

}
