package 스트림;

import java.util.ArrayList;
import java.util.List;

// 자바8에서 도입, 배열, 컬렉션 등의 자료를 반복문 없이 람다식을 이용해 간결하고 일관된 방식으로 처리
// 일관된 연산 : 자료의 대상과 관계없이 동일한 연산 수행
// 내부 반복 : 내부 반복을 사용하여 작업 수행
// 원본 데이터 불변
// 지연 연산 : 중간 연산은 지연(lazy)되어 최종 연산이 호출될 때 수행
//병렬 처리 지원

public class StreamMain {
    public static void main(String[] args) {
//        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        Arrays.stream(arr)
//                .filter(n->n >= 5)
//                .forEach(n -> System.out.println(n));
        TravelCustomer a = new TravelCustomer("안유진", 23, 1000);
        TravelCustomer b = new TravelCustomer("장원진", 22, 2000);
        TravelCustomer c = new TravelCustomer("이서", 19, 2500);
        TravelCustomer d = new TravelCustomer("레이", 19, 1800);
        List<TravelCustomer> customers = new ArrayList<>();
        customers.add(a);
        customers.add(b);
        customers.add(c);
        customers.add(d);

        System.out.println("고객 명단 순서대로 출력");
        customers.stream().map(customer->customer.getName()).forEach(System.out::println);

        int total = customers.stream().mapToInt(customer->customer.getPrice()).sum();
        System.out.println("총 여행 비용 출력 : " + total);

        System.out.println("==== 20세 이상 명단만 출력 ====");
        customers.stream().filter(customer->customer.getAge() > 20).map(TravelCustomer::getName).sorted().forEach(System.out::println);
    }
}

class TravelCustomer {
    private String name;
    private int age;
    private int price;

    public TravelCustomer(String name, int age, int price) {
        this.name = name;
        this.age = age;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}