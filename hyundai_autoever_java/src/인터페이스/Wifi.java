package 인터페이스;

public class Wifi implements NetworkAdater{
    String company;

    public Wifi(String company){
        this.company = company;
    }

    @Override
    public void connect(){
        System.out.println(company + " WIFI에 연결 되었습니다.");
    }
}

class FiveG implements NetworkAdater{
    String company;

    public FiveG(String company){
        this.company = company;
    }

    @Override
    public void connect(){
        System.out.println(company + " 5G에 연결 되었습니다.");
    }
}

class LTE implements NetworkAdater{
    String company;

    public LTE(String company){
        this.company = company;
    }

    @Override
    public void connect(){
        System.out.println(company + " LTE에 연결 되었습니다.");
    }
}

