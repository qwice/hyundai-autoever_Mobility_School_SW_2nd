package 참조;

public class RefType {
    public static void main(String[] args) {
        String name1 = "안유진";
        String name2 = "안유진";
        String name3 = new String("안유진");

        System.out.println(name1 == name2);
        System.out.println(name1 == name3);
        System.out.println(name3 == name2);
    }
}
