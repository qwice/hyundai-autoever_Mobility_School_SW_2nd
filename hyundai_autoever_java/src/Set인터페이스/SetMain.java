package Set인터페이스;

import java.util.HashSet;

public class SetMain {
    public static void main(String[] args) {
        HashSet<Member> set = new HashSet<>();
        set.add(new Member(1001, "유나"));
        set.add(new Member(1002, "채원"));
        set.add(new Member(1002, "지수"));
        set.add(new Member(1003, "카리나"));

        for(Member member : set){
            System.out.println(member);
        }
    }
}

class Member {
    int id;
    String name;
    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Member){
            Member member = (Member) obj;
            if(this.id == member.id){
                return true;
            }
        }
        return false;
    }

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Member [id=" + id + ", name=" + name + "]";
    }
}
