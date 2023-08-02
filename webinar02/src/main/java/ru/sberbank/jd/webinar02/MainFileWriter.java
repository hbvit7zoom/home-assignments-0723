package ru.sberbank.jd.webinar02;

import java.io.FileWriter;
import java.io.IOException;

public class MainFileWriter {

    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("2.txt", true);
            String encoding = writer.getEncoding();
            System.out.println(encoding);

//            writer.write("123\n");
//            writer.write("123\n");
//            writer.write("123\n");
            writer.write("456\n");

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
;