package somepackage;

import java.util.Comparator;

public class MyTreeSet<T> {

    private Node<T> root;
    private Comparator<T> comparator;

    static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;
    }

    public MyTreeSet(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        Node<T> node = new Node<>();
        node.value = item;
        if (root == null) {
            root = node;
            return;
        }

        Node<T> current = root;

        while (true) {
            int result = comparator.compare(item, current.value);
            if (result < 0) {
                if (current.left == null) {
                    current.left = node;
                    return;
                } else {
                    current = current.left;
                }
            } else if (result > 0) {
                if (current.right == null) {
                    current.right = node;
                    return;
                } else {
                    current = current.right;
                }
            }
        }
    }

    public boolean remove(T item) {
        return true;
    }
}
