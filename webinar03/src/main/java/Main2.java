public class Main2 {

    public static void main(String[] args) {
        Adder2<CustomInteger> a1 = new Adder2<>();
        Adder2<CustomLong> a2 = new Adder2<>();

        CustomInteger add1 = a1.add(new CustomInteger(5), new CustomInteger(-5));
        System.out.println(add1);

        CustomLong add2 = a2.add(new CustomLong(5L), new CustomLong(5L));
        System.out.println(add2);
    }
}
