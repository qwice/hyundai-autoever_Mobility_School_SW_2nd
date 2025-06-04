package 어레이리스트1;

import java.util.ArrayList;

public class ArrayListMain {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>(); // List 인터페이스의 참조 변수에 ArrayList 객체 주소 대입
        // 요소 추가
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add(1, "Grape");
        System.out.println(fruits);

        // 요소 가져오기 : get(index)
        System.out.println(fruits.get(0));
        System.out.println(fruits.get(1));
        System.out.println(fruits.get(2));
        System.out.println(fruits.get(3));
        System.out.println();

        // 요소 제거하기 : remove(index)
        fruits.remove(0);
        System.out.println(fruits.get(0));
        System.out.println(fruits);

        // 크기 : size()
        System.out.println(fruits.size());

        // 반복하기 : 향상된 for
        for(String e : fruits){
            System.out.print(e + " ");
        }
        System.out.println();

        // 포함 여부 확인
        System.out.println(fruits.contains("Banana"));
    }
}
