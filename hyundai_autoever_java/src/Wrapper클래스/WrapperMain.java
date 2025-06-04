package Wrapper클래스;

public class WrapperMain {
    public static void main(String[] args) {
        int age = 100; // 일반 변수
        Age ageObject = new Age();
        ageObject.age = 100;
    }
}

class Age{
    int age;
}
