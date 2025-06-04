package 컴페어레이터;

public class CarComp implements Comparable<CarComp>{
    String name; // 자동차 이름
    int year; // 연식
    String color; // 색상

    public CarComp(String name, int year, String color) {
        this.name = name;
        this.year = year;
        this.color = color;
    }

    @Override
    public int compareTo(CarComp o) {
        if(this.year == o.year){
            return this.name.compareTo(o.name); // 사전순 정렬
        } else if(this.year < o.year){
            return -1; // 정렬하지 않는 조건
        } else return 1; // 정렬하는 조건, 오름차순 정렬
    }
}
