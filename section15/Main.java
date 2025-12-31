import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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
    }
}
