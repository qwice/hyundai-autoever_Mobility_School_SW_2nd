package 인터페이스;

import java.sql.SQLOutput;
import java.util.Scanner;

public class NetworkMain {
    public static void main(String[] args) {
        NetworkAdater networkAdater = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("연결 할 네트워크를 선택하세요 [1]WIFI [2]5G [3]LTE : ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1: {
                networkAdater = new Wifi("KT megapass");
                networkAdater.connect();
                break;
            }

            case 2: {
                networkAdater = new FiveG("SK Telecom");
                networkAdater.connect();
                break;
            }

            case 3: {
                networkAdater = new LTE("LG U+");
                networkAdater.connect();
                break;
            }

            default: {
                System.out.println("네트워크 선택이 잘 못 되었습니다.");
            }
        }
    }
}
