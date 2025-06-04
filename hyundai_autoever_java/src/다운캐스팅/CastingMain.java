package 다운캐스팅;

import java.util.ArrayList;

public class CastingMain {
    ArrayList<Animal> aniList = new ArrayList<>();
    public static void main(String[] args) {
        CastingMain downCasting = new CastingMain();
        downCasting.addAnimal();
    }

    public void addAnimal() {
        aniList.add(new Animal());
        aniList.add(new Human());
        aniList.add(new Tiger());
        aniList.add(new Eagle());

        for(Animal animal : aniList) {
            animal.move();
        }
    }

    public void testCasting(){
        for(int i = 0 ; i < aniList.size() ; i++){
            Animal animal = aniList.get(i); // 해당 인덱스의 요소를 추출, 업케스팅
            if(animal instanceof Human){
                Human human = (Human) animal;
                human.readBook();
            } else if(animal instanceof Tiger){
                Tiger tiger = (Tiger) animal;
                tiger.hunting();
            } else if(animal instanceof Eagle){
                Eagle eagle = (Eagle) animal;
                eagle.flying();
            } else {
                System.out.println("지원되지 않는 형 입니다.");
            }
        }
    }
}
