package 컴페어레이터;

import java.util.TreeSet;

public class CompMain {
    public static void main(String[] args) {
        TreeSet<CarComp> set = new TreeSet<>();
        set.add(new CarComp("Cona", 2022, "white"));
        set.add(new CarComp("Santafe", 2018, "gray"));
        set.add(new CarComp("Grandual", 2016, "black"));
        set.add(new CarComp("GV80", 2023, "white"));

        for(CarComp carComp : set){
            System.out.println(carComp.name + " : " + carComp.year);
        }
    }
}
