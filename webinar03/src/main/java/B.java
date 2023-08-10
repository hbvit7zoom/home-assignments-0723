public class B<T> implements A<T> {

    @Override
    public void test(T t) {
        System.out.println("T");
    }

    public static void main(String[] args) {
        B<Integer> b = new B<>();
        b.test(1);
    }
}
