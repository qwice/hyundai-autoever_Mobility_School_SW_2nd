package 미니프로젝트_자동차;

public class SportCar extends Car implements Audio, AutoDrive{
    public SportCar() {
        super(250, 8, 30, 2, "람보르기니 아벤타도르");
    }

    public void setMode(boolean func) {
        if(func) {
            speed *= 1.2;
        }
    }

    @Override
    public String audioInfo() {
        return "오디오 ON";
    }

    @Override
    public String autoDriveInfo() {
        return "자율주행 ON";
    }
}
