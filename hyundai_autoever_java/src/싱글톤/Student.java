package 싱글톤;

public class Student {
    //내부 인스턴스 필드의 이미 생성되어 있는 싱글톤의 객체 주소를 대입
    Singleton singleton = Singleton.getSingleton();

    void setInfo(String name, int id) {
        singleton.name = name;
        singleton.id = id;
    }

    void viewInfo() {
        System.out.println("이름은 : " + singleton.name);
        System.out.println("학번 : " + singleton.id);
    }
}
