import java.util.ArrayList;
import java.util.List;

public class Main {

    static boolean snt(int n) {
        if(n < 2) return false;
        for(int i=2; i*i<=n; i++) {
            if(n%i == 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
//        List<Integer> litst = new ArrayList<>();
//        int a = 0;
//        for(; a<100; a++) {
//            if(Main.snt(a)) litst.add(a);c
//        }
//
//        for(Integer x : litst) System.out.printf(x+ " ");
//        int d = 10;
//        Integer c = 10;
//        System.out.println(d == c);
        Person person = new Person("An Hao");
        person.setAddress(new Person.Address("Duong vo thi 6"));
        System.out.println(person.toString());
    }
}
