package 컴페어레이터;

import java.util.Set;
import java.util.TreeSet;

public class Example {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2); // 길이가 같으면 사전 순 정렬
            }
            return o1.length() - o2.length(); // 길이 순으로 정렬
        });;
        set.add("people");
        set.add("person");
        set.add("blue");
        set.add("red");
        set.add("yellow");
        set.add("person");

        for (String s : set) {
            System.out.println(s);
        }
    }
}
