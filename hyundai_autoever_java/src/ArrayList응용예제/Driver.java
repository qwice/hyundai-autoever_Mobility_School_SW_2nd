package ArrayList응용예제;

import java.math.BigDecimal;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Order order = new Order();

        while(true) {
            System.out.println("\n==== 주문 관리 시스템 ====");
            System.out.println("1. 제품 추가");
            System.out.println("2. 제품 제거");
            System.out.println("3. 제품 목록 보기");
            System.out.println("4. 제품 보기");
            System.out.println("5. 최종 가격 계산 (세금 포함)");
            System.out.println("6. 종료");
            System.out.print("원하는 작업을 선택하세요: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                {
                    System.out.print("제품 이름을 입력하세요 : ");
                    String name = sc.next();
                    System.out.print("제품 가격을 입력하세요 : ");
                    String price = sc.next();
                    order.addItem(new Product(name, price));
                    break;
                }
                case 2:
                {
                    System.out.print("제거할 제품 이름을 입력하세요 : ");
                    String name = sc.next();
                    order.removeItem(name);
                    break;
                }
                case 3:
                {
                    for(Product p : order.getProduct()){
                        System.out.println(p.name + " " + p.price);
                    }
                    break;
                }
                case 4:
                {
                    System.out.print("확인할 제품 이름을 입력하세요 : ");
                    String name = sc.next();
                    Product p = order.getItem(name);
                    if(p == null) System.out.println("해당 제품이 없습니다.");
                    else System.out.println(p.name + " " + p.price);
                    break;
                }
                case 5:
                {
                    System.out.print("세율을 입력하세요 : ");
                    String tax = sc.next();
                    System.out.println("최종 가격은 " + order.calculateFinalPrice(new BigDecimal(tax)) + "입니다.");
                    break;
                }
                case 6:
                {
                    System.out.println("종료합니다.");
                    sc.nextLine();  // 버퍼 비우기
                    sc.close();
                    return;
                }
            }
        }
    }
}
