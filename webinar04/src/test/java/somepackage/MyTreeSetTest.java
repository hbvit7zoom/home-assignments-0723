package somepackage;

import static org.junit.Assert.*;

import java.util.Comparator;
import org.junit.Test;

public class MyTreeSetTest {

    Comparator<Integer> comparator = Comparator.naturalOrder();
    MyTreeSet<Integer> set = new MyTreeSet<>(comparator);

    @Test
    public void addRoot() {
        set.add(50);
        set.add(40);
        set.add(60);
        set.add(35);
    }
}