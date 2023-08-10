import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CustomLinkedListTest {


    @Test
    public void testSizeForEmptyList() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testSizeForNonEmptyList() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        Assert.assertTrue(list.add(10));
        Assert.assertEquals(1, list.size());
    }

    @Test
    public void testSizeForFourElements() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(10);
        Assert.assertEquals(4, list.size());
    }

    @Test
    public void testRemove() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        Assert.assertEquals(4, list.size());
        list.remove(2);
        Assert.assertEquals(3, list.size());
    }

    @Test
    public void testRemove1() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(10);
        Assert.assertEquals(1, list.size());
        list.remove(0);
    }
}