package ru.sberbank.jd.webinar02;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class MainOutputStream {

    public static void main(String[] args) {
        try (OutputStream os = new FileOutputStream("3.txt");
                BufferedOutputStream bos = new BufferedOutputStream(os)) {

            byte b = (byte) 1072;
            bos.write(0xD0);
            bos.write(0xB0);
            bos.write(10);
            bos.write(48);
            bos.write(49);
            bos.write(50);
            bos.write(10);
            bos.write("абв\n".getBytes(StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
