package somepackage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main1 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("One1");
        list.add("two");
        list.add("Three");

        System.out.println(list);

        Main1 main1 = new Main1();
        list.sort(main1.new MyComparator());

//        list.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//
////                Если o1 нарушен порядок o2 - то возвращается пол
////                Если o1 по порядку o2 - то возвращается отр
////                Если o1 == (equals) o2 - то возвращается 0
//                return -(o1.length() - o2.length());
//            }
//        });

//        list.sort((String o1, String o2) -> {
//
//            return -(o1.length() - o2.length());
//        });


        System.out.println(list);

    }


    class MyComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }
}
