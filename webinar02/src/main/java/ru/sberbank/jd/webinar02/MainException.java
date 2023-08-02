package ru.sberbank.jd.webinar02;

public class MainException {

//    public static void main(String[] args) throws Exception {
//
//
//
//        throw new Exception();
//    }

    public static void main(String[] args) {

        try {
            throw new Exception("Some error");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
