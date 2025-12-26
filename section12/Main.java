import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        BimBip bimBip = new BimBip("bimbip");
        bimBip.bay();
        System.out.println();
        bimBip.xinChao();
        List<String> l = new ArrayList<>();
        ArrayList<String> l1 = new ArrayList<>();

//        bimbip dang bay!
//        Hello world!

        System.out.println(bimBip.getTuoi());

        Integer[] arr = new Integer[]{3, 2, 1};
        System.out.println(Arrays.toString(arr));

//        ✅ 1. int[] → Integer[]
        System.out.println("========");

        int[] arr1 = new int[]{8, 3, 1, 2, 4};
        Integer[] arr2 = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
        for (int x : arr2) System.out.print(x + " "); // 8 3 1 2 4
        System.out.println("");

        Integer[] arr3 = Arrays.stream(arr1)
                .boxed()
                .toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr3)); // [8, 3, 1, 2, 4]
        System.out.println("========");

        // ✅ 2. Integer[] → int[]
        Integer[] a = new Integer[]{3, 2, 1, 1};
        Integer[] b = new Integer[]{3, 2, 1, 1, null};

        int[] a1 = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            a1[i] = a[i];
        }
        for (int x : a1) System.out.print(x + " "); // 3 2 1 1
        System.out.println("");

        int[] b1 = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            if (Objects.nonNull(b[i])) { // check null
                b1[i] = b[i];
            }
        }
        for (int x : b1) System.out.print(x + " "); // 3 2 1 1 0 default 0 maybe
        System.out.println("");

        int[] a_2 = Arrays.stream(a)
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println(Arrays.toString(a_2)); // [3, 2, 1, 1]

        int[] b_2 = Arrays.stream(b)
                .filter(Objects::nonNull) // filter non null tránh nullpointerexception
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println(Arrays.toString(b_2)); // [3, 2, 1, 1]

        // ✅ 3. Integer[] → List<Integer>
        Integer[] c = new Integer[]{3,2,1,3,null};

//        List<Integer> e = Arrays.asList(c); // được mà lỗi không hỗ trợ add remove ...
//        System.out.println(e.toString()); // [3, 2, 1, 3, null]

        List<Integer> d = new ArrayList<>(Arrays.asList(c));
        d.add(3);
        System.out.println(d.toString()); // [3, 2, 1, 3, null, 3]    => cái này thì đuọợc

        List<Integer> d_1 = new ArrayList<>();
        for(Integer x : c) d_1.add((x));
        System.out.println(d_1); // [3, 2, 1, 3, null]

        // ✅ 4. List<Integer> → Integer[]
        List<Integer> roi = Arrays.asList(3,2,1,22,null);
        Integer[] roi_a = roi.toArray(Integer[]::new);
        System.out.println(Arrays.toString(roi_a)); // [3, 2, 1, 22, null]

        Integer[] roi_b = roi.toArray(new Integer[0]);
        System.out.println(Arrays.toString(roi_b)); // [3, 2, 1, 22, null]

        Integer[] roi_c = new Integer[roi.size()];
        for(int i=0; i<roi.size(); i++) {
            roi_c[i] = roi.get(i);
        }
        System.out.println("roi_c: " + Arrays.toString(roi_c)); // roi_c: [3, 2, 1, 22, null]

        // ✅ 5. int[] → List<Integer>
        int[] f = new int[]{3,2,1,3,2};
        List<Integer> p = Arrays.stream(f)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(p); // [3, 2, 1, 3, 2]

        List<Integer> p_1 = new ArrayList<>();
        for(int x : f) p_1.add(x);
        System.out.println(p_1); // [3, 2, 1, 3, 2]

        // ✅ 6. List<Integer> → int[]
        List<Integer> m = Arrays.asList(3,2,1,1,3);
        List<Integer> m_1 = Arrays.asList(3,2,1,1,3,null);

        int[] o = new int[m.size()];
        for(int i=0; i< m.size(); i++) {
            o[i] = m_1.get(i);
        }
        System.out.println(Arrays.toString(o)); // [3, 2, 1, 1, 3]

        int[] o_2 = new int[m_1.size()];
        for(int i=0; i< m_1.size(); i++) {
            if(Objects.nonNull(m_1.get(i))) {
                o_2[i] = m_1.get(i);
            }
        }
        System.out.println(Arrays.toString(o_2)); // [3, 2, 1, 1, 3, 0]
        System.out.println(o_2); // [I@70177ecd

        int[] n = m_1.stream()
                .filter(Objects::nonNull) // if not then NullPointer
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.printf(Arrays.toString(n)); // [3, 2, 1, 1, 3]
    }
}
