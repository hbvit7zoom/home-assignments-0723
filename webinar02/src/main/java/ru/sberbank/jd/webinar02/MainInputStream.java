package ru.sberbank.jd.webinar02;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;

public class MainInputStream {

    public static void main(String[] args) {
//        try (InputStream is = new FileInputStream("3.txt")) {
//            int read;
//            while((read = is.read()) != -1) {
//                System.out.print((char) read);
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try (InputStream is = new FileInputStream("3.txt");
                BufferedInputStream bis = new BufferedInputStream(is)) {
            int read;
            String s = new String(bis.readAllBytes());
            System.out.println(s);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
