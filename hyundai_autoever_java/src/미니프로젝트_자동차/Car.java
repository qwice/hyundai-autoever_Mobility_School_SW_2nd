package 미니프로젝트_자동차;

import static java.lang.Math.ceil;

public abstract class Car {
    int speed;
    int kmperL;
    int feul;
    int seat;
    String name;

    public Car(int speed, int kmperL, int feul, int seat, String name) {
        this.speed = speed;
        this.kmperL = kmperL;
        this.feul = feul;
        this.seat = seat;
        this.name = name;
    }

    public int moveCount(int totalPeople){
        return (int)ceil((double)totalPeople / seat);
    }

    public int fuelCount(int totalFeul, int count) {
        return (int)ceil((double)totalFeul / feul * count) ;
    }

    public int totalCost(int totalMove) {
        double spentFeul = totalMove / kmperL;
        return (int)spentFeul * 2000;
    }

    public String totalTime(int distance, int count, double weather) {
        double spentTime = (double)distance / speed * count * weather;
        int H = (int)spentTime / 1;
        int M = (int)ceil(spentTime%1 * 60);
        return H + "시간 " + M  + "분";
    }

    public void getInfo() {
        System.out.println("speed : " + speed);
        System.out.println("kmperL : " + kmperL);
        System.out.println("feul : " + feul);
        System.out.println("seat : " + seat);
        System.out.println("name : " + name);
    }

    public abstract void setMode(boolean func);
}
