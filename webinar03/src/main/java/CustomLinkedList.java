public class CustomLinkedList<T> {

    private Node<T> first;
    private Node<T> last;

    public static class Node<T> {
        T value;

        Node<T> previous;

        Node<T> next;
    }

//    public CustomLinkedList() {
//    }

    public int size() {
        if (first == null) {
            return 0;
        }

        Node<T> current = first;
        int size = 1;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public boolean add(T item) {
        Node<T> node = new Node<>();
        node.value = item;
        if (first == null) {
            first = node;
            last = node;
        } else {
            node.previous = last;
            last.next = node;
            last = node;
        }
        return true;
    }

    void remove(int index) {


        int currentIndex = 0;
        Node<T> current = first;
        while (currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        Node<T> previous = current.previous;
        Node<T> next = current.next;

        previous.next = next;
        next.previous = previous;
    }
}
