package 제네릭;

public class GenericMain {
    public static void main(String[] args) {
        Person<String> p1 = new Person<>("장원영");
        Person<Integer> p2 = new Person<>(1000);
        System.out.println(p1.info);
        System.out.println(p2.info);

        GenericPrinter<Powder> powderPrinter = new GenericPrinter<>();
        powderPrinter.setMaterial(new Powder());
        System.out.println(powderPrinter);
        powderPrinter.getMaterial().doPrinting();

        GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<>();
        plasticPrinter.setMaterial(new Plastic());
        System.out.println(plasticPrinter);
        plasticPrinter.getMaterial().doPrinting();

        GenericPrinter<Water> waterPrinter = new GenericPrinter<Water>();
    }
}

class Person<T> {
    T info;
    Person(T info) {
        this.info = info;
    }
}

