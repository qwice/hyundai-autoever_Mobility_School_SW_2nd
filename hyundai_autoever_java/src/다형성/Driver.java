package 다형성;

public class Driver {
    String name;
    public Driver(String name){
        this.name = name;
    }
    void drive(Vehicle vehicle){
        System.out.println(name + "의 ");
        vehicle.run();
    }
}
