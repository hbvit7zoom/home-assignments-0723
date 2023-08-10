public class Adder2<T extends CustomNumber> {

    public T add(T a1, T a2) {
        return (T) a1.plus(a2);
    }
}
