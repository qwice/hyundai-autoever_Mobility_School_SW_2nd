package 미니프로젝트_자동차;

public class Sedan extends Car implements Aircon, Audio{
    public Sedan() {
        super(200, 12, 45, 4, "아반뗴");
    }

    public void setMode(boolean func) {
        if(func) {
            seat += 1;
        }
    }

    @Override
    public String airconInfo() {
        return "에어컨 ON";
    }

    @Override
    public String audioInfo() {
        return "오디오 ON";
    }
}
