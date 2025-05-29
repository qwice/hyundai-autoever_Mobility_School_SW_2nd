package 에어컨설계;
// 1. 기본 에어컨 만들기
// - 전원 on/off
// - 현재 온도 표시 기능
// - 설정 온도 표시 기능
// - 바람 세기 (1단/2단/3단)
// - 현재 상태 출력 기능
// -- 전원, 현재 온도, 설정 온도, 바람 세기

// 2. 스마트 에어컨
// - 사용자 입력이 없어도 자동으로 20도 설정, 바람 세기는 2단계

// 3. 휴대용 에어컨
// - 배터리 표시 기능 추가

public class AirconMain {
    public static void main(String[] args) {
        DefaultAircon defaultAircon = new DefaultAircon("on", 23, 24, 3);
        SmartAircon smartAircon = new SmartAircon("on");
        PortableAircon portableAircon = new PortableAircon("on", 21, 29, 2, 90);

        defaultAircon.viewAircon();
        smartAircon.viewAircon();
        portableAircon.viewAircon();
    }
}
