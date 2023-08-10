import java.util.ArrayList;
import java.util.List;

public class Main3 {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("some string");
        list.add(Integer.valueOf(1));

        for (Object o : list) {
            if (o instanceof String) {
                String o1 = (String) o;
                System.out.println(o1);
            } else if (o instanceof Integer) {
                String s = "" + o;
                System.out.println(s);
            }

        }

        List<String> list1 = new ArrayList<>();

        for (String s : list1) {
            
        }

    }

}
