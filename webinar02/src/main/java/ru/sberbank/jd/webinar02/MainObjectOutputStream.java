package ru.sberbank.jd.webinar02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MainObjectOutputStream {

    public static void main(String[] args) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("4.bin"))) {
            objectOutputStream.writeObject("абв");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
