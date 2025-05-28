package 향상된for;
// 양의 정수 n을 입력 받아 n * n 크기의 행렬을 출력하는 프로그램 작성
// 이 때 행렬의 값은 1부터 시작하여 왼쪽에서 오른쪽, 위에서 아래 순서대로 채워 넣음.
// 2
// 1 2
// 3 4

import java.util.Scanner;

public class SquareEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int n = sc.nextInt();

        int p = 1;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(n >= 4 && p < 10) System.out.print(" ");
                System.out.print(p++);
                if(j != 3) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
