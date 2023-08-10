package builder;

public class A {

    private String s;
    private String s1;
    private String s2;

    public A() {
    }

    public A(String s) {
        this.s = s;
    }

    public A(String s, String s1, String s2) {
        this.s = s;
        this.s1 = s1;
        this.s2 = s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    public static class ABuilder {

        private String s;

        private String s1;
        private String s2;
        public ABuilder() {
        }

        public ABuilder(String s, String s1, String s2) {
            this.s = s;
            this.s1 = s1;
            this.s2 = s2;
        }

        ABuilder s(String s) {
            this.s = s;
            return this;
        }

        ABuilder s1(String s1) {
            this.s1 = s1;
            return this;
        }

        ABuilder s2(String s2) {
            this.s2 = s2;
            return this;
        }

        A build() {
            return new A(this.s);
        }
    }


    public static void main(String[] args) {
        A a = new ABuilder().s2("Поле s2")
                .build();

        A a1 = new A(null, null, "Поле s2");

        A a11 = new A(null, "Поле s2", null);

        A a2 = new A();
        a2.setS2("Поле s2");
    }


}
