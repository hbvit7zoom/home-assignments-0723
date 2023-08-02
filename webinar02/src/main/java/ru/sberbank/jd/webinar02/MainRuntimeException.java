package ru.sberbank.jd.webinar02;

public class MainRuntimeException {

    public static void main(String[] args) {

        throw new RuntimeException("Some exception");
//        try {
//            throw new SomeException("Some exception");
//        } catch (RuntimeException e) {
//            System.out.println("Возникло исключение");
//        }
    }

}
