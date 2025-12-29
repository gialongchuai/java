import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{33,2,1,2,3};
        Integer[] a_1 = Arrays.stream(a)
                .boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(a_1)); // [33, 2, 1, 2, 3]

        Integer[] b = new Integer[]{3,2,1,3};
        int[] b_1 = Arrays.stream(b).mapToInt(Integer::intValue).toArray();

        List<Integer> l = Arrays.asList(3,2,1,3);
        String roi = "hello world!";
        System.out.println(roi.charAt(2)); // l
        System.out.println(roi.length()); // 12
        System.out.println(String.format("%s xin chao the gioi voi %d dollars", "Tuan Anh", 5)); // Tuan Anh xin chao the gioi voi 5 dollars

        String cat = roi.substring(2,3);
        String cat1 = roi.substring(2);
        String cat2 = roi.substring(2,5);

        System.out.println(cat); // l
        System.out.println(cat1); // llo world!
        System.out.println(cat2); // llo

        System.out.println(roi.toUpperCase().endsWith("HELLO WORLD!")); // true

        String c = String.join("- ", "Hello ", "World!"); // Hello - World!
        String c1 = String.join("- ", "Hello ", "World!", " 789 roi!"); // Hello - World!-  789 roi!
        String c2 = String.join("- ", "Hello a"); // Hello a
        System.out.println(c);
        System.out.println(c1);
        System.out.println(c2);

        String d = new String("Hello universe!");
        System.out.println(d.equals("universe")); // false
        System.out.println(d.equals("Hello universe!")); // true

        System.out.println(d.equalsIgnoreCase("HELLO UNIVERSE!")); // true

        System.out.println("========");
        String n = null;
        System.out.println(Objects.isNull(n)); // true

        // Kiem tra rong
        System.out.println("==== String s ====");
        String s = "";
        System.out.println(s.isEmpty()); // true
        System.out.println(s.isBlank()); // true

        // but
        System.out.println("===== String s1 =====");
        String s1 = "    ";
        System.out.println(s1.isEmpty()); // false
        System.out.println(s1.isBlank()); // true
        System.out.println(s1.trim().isEmpty()); // true

        String re = "Xin chào thế giới, ta là chiến thắng anh hùng!";
        System.out.println(re.replace("a", "@")); // Xin chào thế giới, t@ là chiến thắng @nh hùng!
        System.out.println(re); // Xin chào thế giới, ta là chiến thắng anh hùng!

        String xin = "hello world";
        Integer o = null;
        System.out.println(String.valueOf(o)); // null
        String con = String.valueOf(o);
        System.out.println(con.equals("null")); // true

        StringBuilder stringBuilder = new StringBuilder(xin);
        StringBuilder stringBuilder1 = new StringBuilder("Xin chao");

        Set<Integer> set = new HashSet<>();

        LinkedList<String> l1 = new LinkedList<>();
        for(int i=0; i<5; i++) {
            l1.add("Hello " + i);
        }
        for(String x : l1) System.out.print(x + " "); // Hello 0 Hello 1 Hello 2 Hello 3 Hello 4
        System.out.println(l1.get(3)); // Hello 3 // nhìn như z chứ ko hỗ tợ index

        System.out.println("========Set ======= ");
        Set<String> se = new HashSet<>();
        for(int i=0; i<20; i++) {
            se.add(i + "hi");
        }
        for(String x : se) System.out.print(x + " "); // 17hi 0hi 16hi 1hi 15hi 2hi 14hi 3hi 13hi 4hi 12hi 5hi 11hi 6hi 10hi 7hi 8hi 9hi 19hi 18hi
                            //  => không theo thứ tự
        System.out.println();
        // Dùng linked
        Set<String> se1 = new LinkedHashSet<>();
        for(int i=0; i<20; i++) {
            se1.add(i+"hi");
        } // 0hi 1hi 2hi 3hi 4hi 5hi 6hi 7hi 8hi 9hi 10hi 11hi 12hi 13hi 14hi 15hi 16hi 17hi 18hi 19hi  => ôcê
        for(String x : se1) System.out.print(x + " ");
    }
}
