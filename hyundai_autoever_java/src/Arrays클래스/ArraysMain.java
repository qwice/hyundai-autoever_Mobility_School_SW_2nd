package Arrays클래스;
// 배열을 다루기 위한 다양한 메소드 포함

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArraysMain {
//    public static void main(String[] args) {
//        int[] arr = {5, 4, 3, 7, 9, 8, 2, 1};
//        Integer[] intArr = {5, 4, 3, 7, 9, 8, 2, 1};
//        Arrays.sort(arr); // 오름차순
//
//        Arrays.sort(intArr, Collections.reverseOrder()); // 내림차순
//
//        System.out.println(Arrays.toString(arr));
//        for(int e : arr){
//            System.out.print(e + " ");
//        }
//        System.out.println();
//    }
    public static void main(String[] args) {
        // 이름의 길이 순으로 정렬하고 길이가 같은 경우 사전순으로 정렬하기
        String[] fruits = {"Kiwi", "Orange", "Apple", "Banana", "Melon", "Mango", "Watermelon", "Cherry", "Plum", "Peach"};
        Arrays.sort(fruits, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return o1.length() - o2.length(); // return 1, 양수는 정렬 조건
                } else if(o1.length() == o2.length()) {
                    return o1.compareTo(o2); // 사전순 정렬
                } else {
                    return -1;
                }
            }
        });
        System.out.println(Arrays.toString(fruits));
    }
}

