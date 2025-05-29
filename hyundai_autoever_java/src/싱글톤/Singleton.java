package 싱글톤;
// 싱글톤 : 프로그램 전체에서 단 하나의 객체만 만들도록 보장
// 1. 메모리 절약 : spring의 bean container
// 2. 데이터 공유
// 싱글톤은 전역으로 사용되는 객체이므로 동시 접근 문제가 발생 할 수 있음

public class Singleton {
    String name;
    int id;
    private static Singleton singleton = new Singleton();
    private Singleton() { // 생성자를 숨김
        name = "곰돌이 사육사";
        id = 100;
    }

    // 클래스 메서드 : 미리 생성된 싱글톤 객체의 주소를 반환
    static Singleton getSingleton() {
        return singleton;
    }
}
