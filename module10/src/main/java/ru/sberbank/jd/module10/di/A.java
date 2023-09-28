package ru.sberbank.jd.module10.di;

public class A {
    private final String content;

    public A(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

class B {
    private final A a;
    B(A a) {
        this.a = a;
        //        this.a = new A(" content from B");
    }
    public void sayHello() {
        System.out.println(a.getContent());
    }
}



class MainClass {
    public static void main(String[] args) {
        A a = new A("I am A class");
        B b = new B(a);
        b.sayHello();
    }
}
