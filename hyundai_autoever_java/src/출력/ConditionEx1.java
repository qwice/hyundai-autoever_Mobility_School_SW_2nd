package 출력;

import java.util.Scanner;

public class ConditionEx1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();
        if(M >= 45) M -= 45;
        else {
            if(H == 0) H = 23;
            else H -= 1;
            M = M + 15;
        }

        System.out.println(H);
        System.out.println(M);
    }
}
