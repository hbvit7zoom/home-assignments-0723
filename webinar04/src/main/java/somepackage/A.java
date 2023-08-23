package somepackage;

import java.util.Objects;

public class A {

    public String str;
    public String str1;

    public A() {
    }

    public A(String str) {
        this.str = str;
    }

    public A(String str, String str1) {
        this.str = str;
        this.str1 = str1;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        A a = (A) o;

        return Objects.equals(str, a.str);
    }

    @Override
    public int hashCode() {
        return str != null ? str.hashCode() : 0;
    }

    public static void main(String[] args) {
        A a1 = new A("123", "456");
        A a2 = new A( "456", "123");

        System.out.println(a1.equals(a2));
        System.out.println(a1.hashCode());
        System.out.println(a2.hashCode());
    }
}
