package 출력;
// 자바는 표준 입출력 클래스를 사용해서 콘솔에서 입력과 출력을 담당
// System.in : 표준 입력
// System.out : 표준 출력
// System.err : 오류 출력
// 서식 지정자 : %d, %ld, %d, %.2f, %2d, %s, %c, %%
// 이스케이프시퀀스 : \n, \r, \t, \b, \\

public class PrintClass {
    public static void main(String[] args) {
        String name = "장원영";
        String addr = "서울시 금천구 가산동";
        char gender = 'M';
        int age = 26;
        int kor = 99;
        int eng = 99;
        int mat = 40;
        double aver = 0.0;

        // 자바 스타일 : print(), println()
        // 자바 스타일 (print 오버로딩)
        System.out.println("=".repeat(8) + "Java Style" + "=".repeat(8));
        System.out.println("====== Java Style output =======");
        System.out.println("Name : " + name);
        System.out.println("Address : " + addr);
        System.out.println("Gender : " + gender);
        System.out.println("Age : " + age);
        System.out.println("Total : " + (kor + eng + mat));
        System.out.println("Average : " + (double)(kor + eng + mat) / 3);

        // C언어 스타일 (printf 서식지정자)
        System.out.println("====== C Style Output ======");
        System.out.printf("Name : %s\n", name);
        System.out.printf("Address : %s\n", addr);
        System.out.printf("Gender : %c\n", gender);
        System.out.printf("Age : %d\n", age);
        System.out.printf("Total : %d\n", (kor + eng + mat));
        System.out.printf("Average : %.2f\n", (double)(kor + eng + mat)/3);
    }
}
