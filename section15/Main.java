import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main extends Thread {
    public static void main(String[] args) {
//        while(true) {
//            System.out.println("Hello world!");
//        }
        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        System.out.println(numberFormat.format(33323234)); // 33.323.234 ₫

        List<String> product = Arrays.asList("apple", "banana", "watermelon", "blueberry");

        Map<Character, List<String>> list = product.stream().collect(Collectors.groupingBy(o -> o.charAt(0)));

        for(Map.Entry<Character, List<String>> m : list.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        //a [apple]
        //b [banana, blueberry]
        //w [watermelon]

        List<String> a = new ArrayList<>();
        a.add(null);
        System.out.println(a);

        String mess = "email:minhtan0949@gmail.com,id:70,code:code@123";
        String[] cat = mess.split(",");
        String email = cat[0].substring(cat[0].indexOf(':') + 1);
        String id = cat[1].substring(cat[1].indexOf(':') + 1);
        String code = cat[2].substring(cat[2].indexOf(':') + 1);
        System.out.println(email);
        System.out.println(id);
        System.out.println(code);

//        for ()
//        System.out.println(mess);
        System.out.println(Arrays.toString(cat));
        String tmp = "b56wVKNjCBV14RqvpGAecIkb9+VtS+FLhHicaxRXlwk=";
        System.out.println(tmp.length());
        System.out.println(1000 * 60 * 60 * 24 * 14);
        System.out.println(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 10)));
    }
}
