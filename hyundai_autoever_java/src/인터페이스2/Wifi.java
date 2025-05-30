package 인터페이스2;

public class Wifi implements NetworkAdapter {
    @Override
    public void connect() {
        System.out.println("WIFI에 연결 되었습니다.");
    }

    @Override
    public void send(String msg) {
        System.out.println("WIFI >> " + msg);
    }
}

class FiveG implements NetworkAdapter {
    @Override
    public void connect() {
        System.out.println("5G에 연결 되었습니다.");
    }

    @Override
    public void send(String msg) {
        System.out.println("5G >> " + msg);
    }
}
