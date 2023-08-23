package somepackage;

public class Main2 {

    public static void main(String[] args) {
        String s1 = "One";
        String s2 = "Three";
        String s3 = "Three";

        int i = s1.compareTo(s2);
        System.out.println(i);

        i = s2.compareTo(s3);
        System.out.println(i);

        i = s2.compareTo(s1);
        System.out.println(i);
    }
}
