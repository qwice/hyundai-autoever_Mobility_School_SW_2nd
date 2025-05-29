package 필드와메서드;
// 필드 : 필드는 클래스 내부에서 선어된 변수로, 객체의 상태(속성)를 저장 (인스턴스 필드, 정적 필드, 지역 변수)
// 메서드 : 클래스 내부에 정의된 기능을 수행하는 함수
// 학교명은 고정, 학번, 이름, 주소
public class Member {
    private static String school = "가산고"; // 정적 필드
    private int num; // 학번
    private String name; // 이름
    private String addr; // 주소

    // 생성자의 주요 목적은 인스턴스 필드의 초기값을 부여하는 목적
    // 생성자는 클래스 이름과 동일하고 반환 타입이 없음
    public Member() { // 생성자는 만들지 않으면 기본 생성자가 자동으로 생성되어 숨어 있음
        num = 100;
        name = "없음";
        addr = "없음";
    }
    // 정적 메서드 : 클래스 생성 시 생성되고, 객체와 무관
    public static String getSchool() {
        return school;
    }
    // 정적 메서드 : 객체와 무관
    public static void setSchool(String school) {
        Member.school = school;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    // 매개변수가 있는 생성자, 생성자 오버로딩
    public Member(int num, String name, String addr) {
        this.num = num;
        this.name = name;
        this.addr = addr;
    }
}
