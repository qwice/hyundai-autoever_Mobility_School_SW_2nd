package 미니프로젝트_자동차;

import java.util.Scanner;

public class MakeCar {
    public static void main(String[] args) {
        int distance = 0;
        int totalPeople = 0;
        double selWeather = 0.0;
        int selected = 0;
        Car car = null;
        SportCar sportCar = null;
        Sedan sedan = null;
        Bus bus = null;
        boolean func;
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = true;
        boolean flag4 = true;
        boolean flag5 = true;

        Scanner sc = new Scanner(System.in);
        while (flag1) {
            System.out.print("이동 지역 선택 [1]부산 [2]대전 [3]강릉 [4]광주 : ");
            int location = sc.nextInt();
            switch (location) {
                case 1:{
                    distance = 400;
                    flag1 = false;
                    break;
                }
                case 2:{
                    distance = 150;
                    flag1 = false;
                    break;
                }
                case 3:{
                    distance = 200;
                    flag1 = false;
                    break;
                }
                case 4:{
                    distance = 300;
                    flag1 = false;
                    break;
                }
                default:{
                    System.out.println("잘못 입력 하셨습니다.");
                    break;
                }
            }
        }

        while (flag2) {
            System.out.print("이동할 승객 수 입력 (1~100) : ");
            totalPeople = sc.nextInt();
            if(totalPeople >= 1 && totalPeople <= 100) {
                flag2 = false;
            } else {
                System.out.println("잘못 입력 하셨습니다.");
            }
        }

        while (flag3) {
            System.out.print("이동할 차량 선택 [1]스포츠카 [2]승용차 [3]버스 : ");
            selected = sc.nextInt();
            switch (selected) {
                case 1:{
                    car = new SportCar();
                    sportCar = (SportCar) car;
                    flag3 = false;
                    break;
                }
                case 2:{
                    car = new Sedan();
                    sedan = (Sedan) car;
                    flag3 = false;
                    break;
                }
                case 3:{
                    car = new Bus();
                    bus = (Bus)car;
                    flag3 = false;
                    break;
                }
                default:{
                    System.out.println("잘못 입력 하셨습니다.");
                }
            }
        }

        while (flag4) {
            System.out.print("부가 기능 [1]ON [2]OFF : ");
            int extra = sc.nextInt();
            switch (extra) {
                case 1:{
                    func = true;
                    flag4 = false;
                    car.setMode(func);
                    break;
                }
                case 2:{
                    func = false;
                    flag4 = false;
                    car.setMode(func);
                    break;
                }
                default:{
                    System.out.println("잘못 입력 하셨습니다.");
                }
            }
        }

        while (flag5) {
            System.out.print("날씨 [1]맑음 [2]비 [3]눈 : ");
            int weather = sc.nextInt();
            switch (weather) {
                case 1:{
                    selWeather = 1.0;
                    flag5 = false;
                    break;
                }
                case 2:{
                    selWeather = 1.2;
                    flag5 = false;
                    break;
                }
                case 3:{
                    selWeather = 1.4;
                    flag5 = false;
                    break;
                }
                default:{
                    System.out.println("잘못 입력 하셨습니다.");
                }
            }
        }

        System.out.println();
        car.getInfo();
        switch (selected) {
            case 1:{
                System.out.println(car.name + " : " + sportCar.audioInfo());
                System.out.println(car.name + " : " + sportCar.autoDriveInfo());
                break;
            }
            case 2:{
                System.out.println(car.name + " : " + sedan.audioInfo());
                System.out.println(car.name + " : " + sedan.airconInfo());
                break;
            }
            case 3:{
                System.out.println(car.name + " : " + bus.autoDriveInfo());
                System.out.println(car.name + " : " + bus.airconInfo());
                break;
            }
            default:{
                System.out.println("잘못 입력 하셨습니다.");
            }
        }

        System.out.println("========" + car.name + "========");
        System.out.println("총 비용 : " + String.format("%,d원", car.totalCost(distance * car.moveCount(totalPeople))));
        System.out.println("총 주유 횟수 : " + car.fuelCount(distance / car.kmperL, car.moveCount(totalPeople)) + "번");
        System.out.println("총 이동 시간 : " + car.totalTime(distance, car.moveCount(totalPeople), selWeather));
    }
}
